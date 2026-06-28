package com.ufide.tiendaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ufide.tiendaapp.service.ProductoService;

@Controller
public class HomeController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public String home(Model modelo,
            @RequestParam(defaultValue = "Estudiante") String nombre) {
        modelo.addAttribute("nombre", nombre);
        modelo.addAttribute("totalProductos", productoService.total());
        modelo.addAttribute("bajoStock", productoService.bajoStock().size());
        return "home";
    }
}
