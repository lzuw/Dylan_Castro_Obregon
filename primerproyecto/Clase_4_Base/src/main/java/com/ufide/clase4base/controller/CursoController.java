package com.ufide.clase4base.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ufide.clase4base.entity.Curso;
import com.ufide.clase4base.service.CursoService;

@Controller
@RequestMapping("/cursos")
public class CursoController {

        // ---------- DATOS EN MEMORIA (provisorio - se reemplaza en clase 4) ----------
        private final List<Curso> cursos = new ArrayList<>();

        public CursoController() {
                cursos.add(new Curso(1L, "Fundamentos Web",
                                "Introduccion a HTML5, CSS3 y arquitectura cliente/servidor.",
                                3, "Esteban Ortega"));
                cursos.add(new Curso(2L, "Spring Boot",
                                "Backend con Java 25, MVC, Thymeleaf y Bootstrap.",
                                4, "Esteban Ortega"));
                cursos.add(new Curso(3L, "Bases de Datos",
                                "MySQL, Workbench, JPA, Hibernate y modelo relacional.",
                                4, "Esteban Ortega"));
                cursos.add(new Curso(4L, "Patrones de Diseno",
                                "MVC, Repository, Service, Inyeccion de Dependencias.",
                                3, "Esteban Ortega"));
                cursos.add(new Curso(5L, "Seguridad Web",
                                "Autenticacion, autorizacion y buenas practicas con Spring Security.",
                                4, "Esteban Ortega"));
                cursos.add(new Curso(6L, "APIs REST",
                                "Servicios JSON, consumo desde clientes, despliegue en la nube.",
                                3, "Esteban Ortega"));
        }
        // -----------------------------------------------------------------------------

        @Autowired
        private CursoService cursoService;

        @GetMapping
        public String listar(Model modelo) {
                modelo.addAttribute("cursos", cursoService.listar());
                return "cursos";
        }

        @GetMapping("/{id}")
        public String detalle(Model modelo, @PathVariable Long id) {
                Curso encontrado = cursos.stream()
                                .filter(c -> c.getId().equals(id))
                                .findFirst()
                                .orElse(null);
                modelo.addAttribute("curso", encontrado);
                return "curso";
        }
}
