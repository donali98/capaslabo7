package com.dona.labo7.service;

import com.dona.labo7.domain.Estudiante;
import com.dona.labo7.estudiantedto.EstudianteDTO;
import com.dona.labo7.repositories.EstudianteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Estudiante> filtrarApellidoPor(String cadena) throws DataAccessException {
        return estudianteRepo.findByLastNameStartingWith(cadena);
    }

    @Override
    public List<Estudiante> mostrarTodos() throws DataAccessException {
        return estudianteRepo.mostrarTodos();
    }

    @Override
    public List<Estudiante> mostrarPorNombre(String cadena) throws DataAccessException {
        return estudianteRepo.mostrarPorNombre(cadena);
    }

    @Override
    public List<EstudianteDTO> dtoPrueba() throws DataAccessException {
        List<EstudianteDTO> estudianteDTOS = estudianteRepo.pruebaDTO().stream().map(objects -> {
                    EstudianteDTO estudianteDTO = new EstudianteDTO();
                    estudianteDTO.setNombre(objects[0].toString());
                    estudianteDTO.setApellido(objects[1].toString());
                    return estudianteDTO;
                }
        ).collect(Collectors.toList());
        return estudianteDTOS;
    }

    @Override
    public void updateStudent(String nombre, String apellido, Integer edad, Boolean estado,Integer id) throws DataAccessException {
        estudianteRepo.updateStudent(nombre, apellido, edad, estado, id);
    }
}
