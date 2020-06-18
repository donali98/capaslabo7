package com.dona.labo7.service;

import com.dona.labo7.domain.Estudiante;
import com.dona.labo7.repositories.EstudianteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl  implements  EstudianteService{
    @Autowired
    EstudianteRepo estudianteRepo;

    @Override
    public List<Estudiante> findAll() throws DataAccessException { return estudianteRepo.findAll(); }

    @Override
    public Estudiante findOne(Integer code) throws DataAccessException { return estudianteRepo.getOne(code); }

    @Override
    public void save(Estudiante student) throws DataAccessException { estudianteRepo.save(student); }

    @Override
    public void delete(Integer code) throws DataAccessException { estudianteRepo.deleteById(code); }

    @Override
    public List<Estudiante> filtrarPor(String cadena) throws DataAccessException {
        return estudianteRepo.findByName(cadena);
    }
}
