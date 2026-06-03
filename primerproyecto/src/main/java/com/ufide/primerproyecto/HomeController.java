package com.ufide.primerproyecto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
 
@Controller
public class HomeController {
 
    @GetMapping("/")
    public String home(Model model) {
 
        model.addAttribute("nombre", "Clase SC-403");
 
        return "home";
    }
}
