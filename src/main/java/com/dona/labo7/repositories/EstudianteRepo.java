package com.dona.labo7.repositories;

import com.dona.labo7.domain.Estudiante;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EstudianteRepo  extends JpaRepository<Estudiante,Integer> {
    List<Estudiante> findByName(String cadena) throws DataAccessException;
    List<Estudiante> findByLastNameStartingWith(String cadena) throws DataAccessException;

    @Query(nativeQuery = true,value = "select * from public.estudiante")
    List<Estudiante> mostrarTodos() throws DataAccessException;

    //Tambien se puede con parametros enumerados (?1)
    @Query(nativeQuery = true,value = "select * from public.estudiante where nombre=:cadena")
    List<Estudiante> mostrarPorNombre(String cadena) throws DataAccessException;

    @Query(nativeQuery = true,value = "select nombre,apellido from public.estudiante")
    List<Object[]> pruebaDTO() throws DataAccessException;

    @Transactional
    @Modifying
    @Query(nativeQuery= true, value = "update public.estudiante set nombre = :nombre, apellido = :apellido, edad=:edad, estado=:estado where id_estudiante = :id")
    void updateStudent(String nombre, String apellido, Integer edad, Boolean estado,Integer id);

}
