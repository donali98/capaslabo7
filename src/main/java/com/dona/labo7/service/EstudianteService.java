package com.dona.labo7.service;

import com.dona.labo7.domain.Estudiante;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface EstudianteService {
    public List<Estudiante> findAll() throws DataAccessException;
    public Estudiante findOne(Integer code) throws DataAccessException;
    public void save(Estudiante student) throws DataAccessException;
    public void delete(Integer code) throws DataAccessException;

}
