package com.ufide.tiendaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Punto de entrada de la aplicacion.
 *
 * @SpringBootApplication escanea este paquete y todos los sub-paquetes
 * buscando @Controller, @Service, @Repository, @Entity, etc.
 */
@SpringBootApplication
public class TiendaappApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiendaappApplication.class, args);
    }
}
