package com.dona.labo7.controller;

import com.dona.labo7.domain.Estudiante;
import com.dona.labo7.estudiantedto.EstudianteDTO;
import com.dona.labo7.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/estudiante")
    public ModelAndView initMain() {
        ModelAndView mav = new ModelAndView();
        List<Estudiante> students = null;
        try {
//            students = estudianteService.findAll();
            students = estudianteService.mostrarTodos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("students", students);
        mav.setViewName("main");
        return mav;
    }

    @GetMapping("/insertarEstudiante")
    public ModelAndView inicio() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("student", new Estudiante());
        mav.setViewName("agregarEstudiante");
        return mav;
    }

    @PostMapping("/modificarEstudiante")
    public ModelAndView showModifyForm(@RequestParam(value = "codigo") int id) {
        ModelAndView mav = new ModelAndView();
        Estudiante estudiante = null;
        try{
            estudiante = estudianteService.findOne(id);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        mav.addObject("student", estudiante);
        mav.setViewName("updateForm");
        return mav;
    }

    @PostMapping(value = "/mostrarEstudiante")
    public ModelAndView findOne(@RequestParam(value = "codigo") int id) {
        ModelAndView mav = new ModelAndView();
        Estudiante student = null;
        try {
            student = estudianteService.findOne(id);
        }
        catch(Exception e) {
            e.printStackTrace();
        }


        mav.addObject("student", student);
        mav.setViewName("estudiante");

        return mav;
    }
    @PostMapping(value = "/borrarEstudiante")
    public ModelAndView delete(@RequestParam(value = "codigo") int id) {
        ModelAndView mav = new ModelAndView();
        List<Estudiante> students = null;
        try{
            estudianteService.delete(id);
            students = estudianteService.findAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        mav.addObject("students", students);
        mav.setViewName("main");
        return mav;
    }
    @PostMapping("modify")
    public ModelAndView modify(
            @RequestParam(value = "name") String nombre,
            @RequestParam(value = "lastName") String apellido,
            @RequestParam(value = "age") Integer edad,
            @RequestParam(value = "state") Boolean estado,
            @RequestParam(value = "codStudent") int id
            ) {
        ModelAndView mav = new ModelAndView();
        List<Estudiante> students = null;
        try{
            estudianteService.updateStudent(nombre,apellido,edad,estado,id);
            students = estudianteService.findAll();
        }catch(Exception e){
            e.printStackTrace();
        }
        mav.addObject("students", students);
        mav.setViewName("main");
        return mav;
    }
    @PostMapping(value = "/filtrar")
    public ModelAndView filtro(@RequestParam(value = "nombre") String cadena) {
        ModelAndView mav = new ModelAndView();
        List<Estudiante> students = null;
        try{
//            students = estudianteService.filtrarPor(cadena);
//            students = estudianteService.filtrarApellidoPor(cadena);
            students = estudianteService.mostrarPorNombre(cadena);
        }catch(Exception e){
            e.printStackTrace();
        }
        mav.addObject("students", students);
        mav.setViewName("main");
        return mav;
    }
    @GetMapping(value = "/mostrarDTO")
    public ModelAndView mostrarDTO() {
        ModelAndView mav = new ModelAndView();
        List<EstudianteDTO> students = null;
        try{
            students = estudianteService.dtoPrueba();
        }catch(Exception e){
            e.printStackTrace();
        }
        mav.addObject("students", students);
        mav.setViewName("pruebaDTO");
        return mav;
    }

    @PostMapping(value="/save")
    public ModelAndView guardar(@Valid @ModelAttribute("student") Estudiante student, BindingResult result) {
        ModelAndView mav = new ModelAndView();
        if(result.hasErrors()) {
            mav.setViewName("agregarEstudiante");
            mav.addObject("student", student);
        }
        else {
            estudianteService.save(student);
            List<Estudiante> students = null;
            try{
                students = estudianteService.findAll();
            }catch(Exception e){
                e.printStackTrace();
            }
            mav.addObject("students", students);
            mav.setViewName("listaEstudiantes");
        }
        return mav;
    }
}
