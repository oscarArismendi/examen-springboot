INSERT INTO paises (id, nombre) VALUES (1, 'Colombia');

INSERT INTO ciudades (id, nombre, pais_id) VALUES (1, 'Bogotá', 1);

INSERT INTO modelo (id, nombre, descripcion) VALUES (1, 'Model A', 'Pro Bike');

INSERT INTO modelo (id, nombre, descripcion) VALUES (2, 'Model B', 'Pro Bike');

INSERT INTO marca (id, nombre) VALUES (1, 'Brand A');

INSERT INTO marca (id, nombre) VALUES (2, 'Brand B');

INSERT INTO proveedores (id, nombre, contacto, email, telefono, ciudad_id) VALUES (1, 'Supplier A', 1234567890, 'supplierA@mail.com', 9876543210, 1);

INSERT INTO compras (id, fecha, proveedor_id, total) VALUES (1, '2024-09-09', 1, 500.00);

INSERT INTO repuestos (id, nombre, descripcion, precio, stock, proveedor_id, modelo, marca) VALUES (1, 'Tire', 'Bicycle Tire', 50.00, 100, 1, 1, 1);

INSERT INTO detalles_compras (id, compra_id, repuesto_id, cantidad, precio_unitario) VALUES (1, 1, 1, 10, 50.00);

INSERT INTO clientes (id, nombre, email, telefono, password, ciudad_id) VALUES (1, 'Client A', 'clienta@mail.com', 9876543211, 'pass123', 1);

INSERT INTO bicicletas (id, modelo, marca, precio, stock) VALUES (1, 1, 1, 1000.00, 50);

INSERT INTO ventas (id, fecha, cliente_id) VALUES (1, '2024-09-09', 1);

INSERT INTO detalles_ventas (id, venta_id, bicicleta_id, cantidad, precio_unitario) VALUES (1, 1, 1, 2, 1000.00);

INSERT INTO detalles_ventas (id, venta_id, bicicleta_id, cantidad, precio_unitario) VALUES (2, 1, 1, 2, 1000.00);
