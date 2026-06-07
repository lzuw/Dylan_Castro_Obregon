package com.ufide.clase4base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model modelo,
            @RequestParam(defaultValue = "Estudiante") String nombre) {
        modelo.addAttribute("nombre", nombre);
        modelo.addAttribute("curso", "SC-403 Desarrollo de Aplicaciones Web");
        return "home";
    }
}
