package com.dona.labo7.service;

import com.dona.labo7.domain.Estudiante;
import com.dona.labo7.estudiantedto.EstudianteDTO;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface EstudianteService {
    List<Estudiante> findAll() throws DataAccessException;
    Estudiante findOne(Integer code) throws DataAccessException;
    void save(Estudiante student) throws DataAccessException;
    void delete(Integer code) throws DataAccessException;
    List<Estudiante> filtrarPor(String cadena) throws DataAccessException;
    List<Estudiante> filtrarApellidoPor(String cadena) throws DataAccessException;
    List<Estudiante> mostrarTodos() throws DataAccessException;
    List<Estudiante> mostrarPorNombre(String cadena) throws DataAccessException;
    List<EstudianteDTO> dtoPrueba() throws DataAccessException;
    void updateStudent(String nombre, String apellido, Integer edad, Boolean estado,Integer id) throws DataAccessException;

}
