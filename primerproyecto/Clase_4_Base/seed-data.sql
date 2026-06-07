-- ============================================================
-- Seed data para Clase 4 - SC-403
-- ============================================================
-- Ejecutar en MySQL Workbench DESPUES de:
--   1) Haber creado la BD cursoswebdb
--   2) Haber arrancado la app con la @Entity Curso
--      (Hibernate crea la tabla automaticamente)
--
-- Estos datos coinciden con los que estaban "en memoria" en
-- CursoController, asi la UI se ve igual antes y despues.
-- ============================================================

USE cursoswebdb;

-- Limpiar la tabla (opcional - solo si quieren empezar fresco)
-- TRUNCATE TABLE cursos;

INSERT INTO cursos (nombre, descripcion, creditos, profesor) VALUES
('Fundamentos Web',
 'Introduccion a HTML5, CSS3 y arquitectura cliente/servidor.',
 3, 'Esteban Ortega'),

('Spring Boot',
 'Backend con Java 25, MVC, Thymeleaf y Bootstrap.',
 4, 'Esteban Ortega'),

('Bases de Datos',
 'MySQL, Workbench, JPA, Hibernate y modelo relacional.',
 4, 'Esteban Ortega'),

('Patrones de Diseno',
 'MVC, Repository, Service, Inyeccion de Dependencias.',
 3, 'Esteban Ortega'),

('Seguridad Web',
 'Autenticacion, autorizacion y buenas practicas con Spring Security.',
 4, 'Esteban Ortega'),

('APIs REST',
 'Servicios JSON, consumo desde clientes, despliegue en la nube.',
 3, 'Esteban Ortega');

-- Verificar
SELECT * FROM cursos;

-- ============================================================
-- Queries utiles para demostrar en clase
-- ============================================================

-- Contar cuantos cursos hay
-- SELECT COUNT(*) AS total FROM cursos;

-- Cursos con mas de 3 creditos
-- SELECT nombre, creditos FROM cursos WHERE creditos > 3;

-- Ordenar por nombre
-- SELECT * FROM cursos ORDER BY nombre ASC;

-- Buscar por nombre parcial
-- SELECT * FROM cursos WHERE nombre LIKE '%Spring%';

-- Borrar uno (para demostrar deleteById)
-- DELETE FROM cursos WHERE id = 6;
