package com.ufide.tiendaapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.ufide.tiendaapp.entity.Producto;
import com.ufide.tiendaapp.service.ProductoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // ── LISTAR ──────────────────────────────────────────────
    @GetMapping
    public String listar(@RequestParam(required = false) String categoria,
                         @RequestParam(required = false) String q,
                         Model m) {
        List<Producto> lista;
        String filtro = null;

        if (categoria != null && !categoria.isBlank()) {
            lista = productoService.buscarPorCategoria(categoria);
            filtro = "Categoría: " + categoria;
        } else if (q != null && !q.isBlank()) {
            lista = productoService.buscarPorNombre(q);
            filtro = "Búsqueda: " + q;
        } else {
            lista = productoService.listar();
        }

        m.addAttribute("productos", lista);
        m.addAttribute("filtro", filtro);
        return "productos";
    }

    // ── DETALLE ─────────────────────────────────────────────
    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model m) {
        Producto p = productoService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " + id));
        m.addAttribute("producto", p);
        return "producto-detalle";
    }

    // ── CREATE GET ───────────────────────────────────────────
    @GetMapping("/nuevo")
    public String mostrarFormNuevo(Model m) {
        m.addAttribute("producto", new Producto());
        return "productos/form";
    }

    // ── CREATE POST ──────────────────────────────────────────
    @PostMapping
    public String guardar(@Valid @ModelAttribute("producto") Producto producto,
                          BindingResult result,
                          RedirectAttributes ra) {
        if (result.hasErrors()) {
            return "productos/form";
        }
        productoService.guardar(producto);
        ra.addFlashAttribute("ok", "Producto guardado correctamente");
        return "redirect:/productos";
    }

    // ── UPDATE GET ───────────────────────────────────────────
    @GetMapping("/{id}/editar")
    public String mostrarFormEditar(@PathVariable Long id, Model m) {
        Producto p = productoService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " + id));
        m.addAttribute("producto", p);
        return "productos/form";
    }

    // ── UPDATE POST ──────────────────────────────────────────
    @PostMapping("/{id}")
    public String actualizar(@PathVariable Long id,
                             @Valid @ModelAttribute("producto") Producto producto,
                             BindingResult result,
                             RedirectAttributes ra) {
        if (result.hasErrors()) {
            return "productos/form";
        }
        producto.setId(id);
        productoService.guardar(producto);
        ra.addFlashAttribute("ok", "Producto actualizado correctamente");
        return "redirect:/productos";
    }

    // ── DELETE ───────────────────────────────────────────────
    @PostMapping("/{id}/eliminar")
    public String eliminar(@PathVariable Long id, RedirectAttributes ra) {
        productoService.eliminar(id);
        ra.addFlashAttribute("ok", "Producto eliminado correctamente");
        return "redirect:/productos";
    }
}