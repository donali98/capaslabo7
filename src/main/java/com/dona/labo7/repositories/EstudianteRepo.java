package com.dona.labo7.repositories;

import com.dona.labo7.domain.Estudiante;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstudianteRepo  extends JpaRepository<Estudiante,Integer> {
    public List<Estudiante> findByName(String cadena) throws DataAccessException;
}
