package com.ufide.tiendaapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ufide.tiendaapp.service.ProductoService;

/**
 * Controlador de productos.
 *
 * Recibe peticiones HTTP, llama al ProductoService y devuelve la vista.
 * Cero logica de negocio aqui - solo orquesta.
 */
@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    /** GET /productos - listar todos o buscar por nombre/categoria */
    @GetMapping
    public String listar(Model modelo,
            @RequestParam(required = false) String buscar,
            @RequestParam(required = false) String categoria) {

        if (buscar != null && !buscar.isBlank()) {
            modelo.addAttribute("productos", productoService.buscarPorNombre(buscar));
            modelo.addAttribute("filtro", "Buscando: " + buscar);
        } else if (categoria != null && !categoria.isBlank()) {
            modelo.addAttribute("productos", productoService.buscarPorCategoria(categoria));
            modelo.addAttribute("filtro", "Categoria: " + categoria);
        } else {
            modelo.addAttribute("productos", productoService.listar());
        }
        return "productos";
    }

    /** GET /productos/{id} - ver detalle de un producto */
    @GetMapping("/{id}")
    public String detalle(Model modelo, @PathVariable Long id) {
        modelo.addAttribute("producto", productoService.buscarPorId(id).orElse(null));
        return "producto";
    }

    /** GET /productos/bajo-stock - productos con menos de 5 unidades */
    @GetMapping("/bajo-stock")
    public String bajoStock(Model modelo) {
        modelo.addAttribute("productos", productoService.bajoStock());
        modelo.addAttribute("filtro", "Productos con bajo stock");
        return "productos";
    }
}
