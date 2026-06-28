package com.ufide.tiendaapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufide.tiendaapp.entity.Producto;

/**
 * Repository de Producto.
 *
 * Extiende JpaRepository<Entidad, TipoDelId> y obtiene gratis:
 *   findAll, findById, save, deleteById, count, existsById, etc.
 *
 * Spring genera la implementacion automaticamente al arrancar.
 * No hay que escribir codigo - solo declarar la interface.
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    /** Query method derivado: SELECT * FROM productos WHERE categoria = ? */
    List<Producto> findByCategoria(String categoria);

    /** Query method derivado: SELECT * FROM productos WHERE stock < ? */
    List<Producto> findByStockLessThan(int max);

    /** Query method derivado: case-insensitive LIKE %nombre% */
    List<Producto> findByNombreContainingIgnoreCase(String nombre);
}
