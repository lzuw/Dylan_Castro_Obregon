package com.ufide.tiendaapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad Producto - representa la tabla productos en MySQL.
 *
 * Anotaciones JPA:
 *   @Entity        -> marca la clase como tabla
 *   @Table         -> nombre custom de la tabla
 *   @Id            -> llave primaria
 *   @GeneratedValue -> auto-incremento
 *   @Column        -> configuracion de la columna
 */
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 500)
    private String descripcion;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private int stock;

    @Column(length = 50)
    private String categoria;

    /** Constructor vacio - obligatorio para JPA. */
    public Producto() {}

    public Producto(String nombre, String descripcion, double precio, int stock, String categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    // Getters y setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    /** Util: marca si hay poco stock. */
    public boolean isBajoStock() {
        return stock > 0 && stock < 5;
    }

    /** Util: marca si esta agotado. */
    public boolean isAgotado() {
        return stock == 0;
    }
}
