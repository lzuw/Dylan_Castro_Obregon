-- ==============================================================
-- Seed data para TiendaApp - Resumen Clases 1 a 4
-- ==============================================================
-- Ejecutar en MySQL Workbench DESPUES de:
--   1) Haber creado la BD tiendadb
--   2) Haber arrancado la app con la @Entity Producto
--      (Hibernate crea la tabla automaticamente)
-- ==============================================================

USE tiendadb;

-- Limpiar la tabla (opcional)
-- TRUNCATE TABLE productos;

INSERT INTO productos (nombre, descripcion, precio, stock, categoria) VALUES
('Laptop ThinkPad X1',
 'Laptop empresarial con procesador Intel i7, 16GB RAM y SSD 512GB.',
 1899.99, 12, 'Electronica'),

('Mouse Inalambrico Logitech',
 'Mouse ergonomico con bateria de larga duracion y receptor USB-C.',
 49.90, 45, 'Accesorios'),

('Teclado Mecanico RGB',
 'Teclado mecanico con switches Cherry MX Red e iluminacion RGB programable.',
 129.50, 3, 'Accesorios'),

('Monitor 27 pulgadas 4K',
 'Monitor IPS 27 pulgadas resolucion 4K, HDR y panel anti-reflejo.',
 449.00, 8, 'Electronica'),

('Audifonos Bluetooth Sony',
 'Audifonos over-ear con cancelacion de ruido activa y 30 horas de bateria.',
 299.99, 0, 'Audio'),

('Webcam Full HD',
 'Camara web 1080p con microfono integrado, ideal para clases virtuales.',
 79.90, 22, 'Electronica'),

('Mochila para Laptop',
 'Mochila resistente al agua con compartimento acolchado para laptop 15 pulgadas.',
 59.50, 1, 'Accesorios'),

('Disco Duro Externo 2TB',
 'Disco USB 3.0 portatil de 2TB para backups y almacenamiento.',
 79.99, 17, 'Almacenamiento'),

('Cargador Universal 65W',
 'Cargador USB-C de 65W compatible con la mayoria de laptops modernas.',
 39.90, 28, 'Accesorios'),

('Tableta Grafica',
 'Tableta para diseno digital con pluma sensible a la presion y area de trabajo amplia.',
 199.00, 4, 'Electronica');

-- Verificar
SELECT id, nombre, categoria, precio, stock FROM productos;

-- ==============================================================
-- Queries utiles para demostrar en clase
-- ==============================================================

-- Contar productos por categoria
-- SELECT categoria, COUNT(*) AS total FROM productos GROUP BY categoria;

-- Productos con bajo stock
-- SELECT nombre, stock FROM productos WHERE stock < 5 ORDER BY stock;

-- Productos ordenados por precio
-- SELECT nombre, precio FROM productos ORDER BY precio DESC;

-- Buscar productos por nombre
-- SELECT * FROM productos WHERE LOWER(nombre) LIKE '%laptop%';

-- Borrar uno (para demostrar deleteById)
-- DELETE FROM productos WHERE id = 10;
