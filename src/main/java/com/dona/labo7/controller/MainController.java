package com.dona.labo7.controller;

import com.dona.labo7.domain.Estudiante;
import com.dona.labo7.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
            students = estudianteService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("students", students);
        mav.setViewName("main");
        return mav;
    }
}
