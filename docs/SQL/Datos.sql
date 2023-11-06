-- Insertando datos en la tabla 'alojamientos'
INSERT INTO alojamientos (activa, usuarios_iduser, checkin, checkout, acompañantes, planes_idplan, cuentas_idcuenta, idalojamiento, habitaciones_idhabitacion) VALUES ('SI', 1, TO_DATE('2023-01-01', 'YYYY-MM-DD'), TO_DATE('2023-01-10', 'YYYY-MM-DD'), 2, 1, 1, 1, 1);
INSERT INTO alojamientos (activa, usuarios_iduser, checkin, checkout, acompañantes, planes_idplan, cuentas_idcuenta, idalojamiento, habitaciones_idhabitacion) VALUES ('NO', 2, TO_DATE('2023-02-15', 'YYYY-MM-DD'), TO_DATE('2023-02-20', 'YYYY-MM-DD'), 1, 2, 2, 2, 2);
INSERT INTO alojamientos (activa, usuarios_iduser, checkin, checkout, acompañantes, planes_idplan, cuentas_idcuenta, idalojamiento, habitaciones_idhabitacion) VALUES ('SI', 3, TO_DATE('2023-03-10', 'YYYY-MM-DD'), TO_DATE('2023-03-15', 'YYYY-MM-DD'), 4, 3, 3, 3, 3);
INSERT INTO alojamientos (activa, usuarios_iduser, checkin, checkout, acompañantes, planes_idplan, cuentas_idcuenta, idalojamiento, habitaciones_idhabitacion) VALUES ('SI', 4, TO_DATE('2023-04-05', 'YYYY-MM-DD'), TO_DATE('2023-04-12', 'YYYY-MM-DD'), 3, 4, 4, 4, 4);
INSERT INTO alojamientos (activa, usuarios_iduser, checkin, checkout, acompañantes, planes_idplan, cuentas_idcuenta, idalojamiento, habitaciones_idhabitacion) VALUES ('NO', 5, TO_DATE('2023-05-01', 'YYYY-MM-DD'), TO_DATE('2023-05-08', 'YYYY-MM-DD'), 2, 5, 5, 5, 5);

-- Insertando datos en la tabla 'bares'
INSERT INTO bares (estilo, idservicio) VALUES ('Frances', 1);
INSERT INTO bares (estilo, idservicio) VALUES ('Italiano', 2);
INSERT INTO bares (estilo, idservicio) VALUES ('Mediterraneo', 3);
INSERT INTO bares (estilo, idservicio) VALUES ('Mexicano', 4);
INSERT INTO bares (estilo, idservicio) VALUES ('Oriental', 5);

-- Insertando datos en la tabla 'conferencias'
INSERT INTO conferencias (capacidad, fecha, hora, duracion, idservicio) VALUES (100, TO_DATE('2023-06-15', 'YYYY-MM-DD'), TO_DATE('09:00', 'HH24:MI'), 120, 1);
INSERT INTO conferencias (capacidad, fecha, hora, duracion, idservicio) VALUES (50, TO_DATE('2023-07-20', 'YYYY-MM-DD'), TO_DATE('13:00', 'HH24:MI'), 90, 2);
INSERT INTO conferencias (capacidad, fecha, hora, duracion, idservicio) VALUES (75, TO_DATE('2023-08-10', 'YYYY-MM-DD'), TO_DATE('10:00', 'HH24:MI'), 60, 3);
INSERT INTO conferencias (capacidad, fecha, hora, duracion, idservicio) VALUES (30, TO_DATE('2023-09-05', 'YYYY-MM-DD'), TO_DATE('16:00', 'HH24:MI'), 45, 4);
INSERT INTO conferencias (capacidad, fecha, hora, duracion, idservicio) VALUES (200, TO_DATE('2023-10-12', 'YYYY-MM-DD'), TO_DATE('08:00', 'HH24:MI'), 180, 5);

-- Insertando datos en la tabla 'cuentas'
INSERT INTO cuentas (netocuenta, idcuenta, alojamientos_idalojamiento) VALUES (5000, 1, 1);
INSERT INTO cuentas (netocuenta, idcuenta, alojamientos_idalojamiento) VALUES (6000, 2, 2);
INSERT INTO cuentas (netocuenta, idcuenta, alojamientos_idalojamiento) VALUES (7000, 3, 3);
INSERT INTO cuentas (netocuenta, idcuenta, alojamientos_idalojamiento) VALUES (8000, 4, 4);
INSERT INTO cuentas (netocuenta, idcuenta, alojamientos_idalojamiento) VALUES (9000, 5, 5);

-- Insertando datos en la tabla 'gimnasios'
INSERT INTO gimnasios (capacidad, maquinas, idservicio) VALUES (20, 'Cintas de correr, bicicletas estáticas', 1);
INSERT INTO gimnasios (capacidad, maquinas, idservicio) VALUES (15, 'Pesas, máquinas de remo', 2);
INSERT INTO gimnasios (capacidad, maquinas, idservicio) VALUES (25, 'Elípticas, bancos de pesas', 3);
INSERT INTO gimnasios (capacidad, maquinas, idservicio) VALUES (30, 'Máquinas de pilates, esterillas', 4);
INSERT INTO gimnasios (capacidad, maquinas, idservicio) VALUES (10, 'Sacos de boxeo, guantes', 5);

-- Insertando datos en la tabla 'habitaciones'
INSERT INTO habitaciones (numhabitacion, disponible, precionoche, hoteles_idhotel, tipos_idtipo, alojamientos_idalojamiento, idhabitacion) VALUES (101, 'SI', 150, 1, 1, 1, 1);
INSERT INTO habitaciones (numhabitacion, disponible, precionoche, hoteles_idhotel, tipos_idtipo, alojamientos_idalojamiento, idhabitacion) VALUES (102, 'SI', 200, 2, 2, 2, 2);
INSERT INTO habitaciones (numhabitacion, disponible, precionoche, hoteles_idhotel, tipos_idtipo, alojamientos_idalojamiento, idhabitacion) VALUES (103, 'NO', 250, 3, 3, 3, 3);
INSERT INTO habitaciones (numhabitacion, disponible, precionoche, hoteles_idhotel, tipos_idtipo, alojamientos_idalojamiento, idhabitacion) VALUES (104, 'SI', 300, 4, 4, 4, 4);
INSERT INTO habitaciones (numhabitacion, disponible, precionoche, hoteles_idhotel, tipos_idtipo, alojamientos_idalojamiento, idhabitacion) VALUES (105, 'NO', 350, 5, 5, 5, 5);

-- Insertando datos en la tabla 'hoteles'
INSERT INTO hoteles (nombrehotel, estrellashotel, idhotel) VALUES ('Hotel Sol', 3, 1);
INSERT INTO hoteles (nombrehotel, estrellashotel, idhotel) VALUES ('Hotel Luna', 4, 2);
INSERT INTO hoteles (nombrehotel, estrellashotel, idhotel) VALUES ('Hotel Estrellas', 5, 3);
INSERT INTO hoteles (nombrehotel, estrellashotel, idhotel) VALUES ('Hotel Cometa', 3, 4);
INSERT INTO hoteles (nombrehotel, estrellashotel, idhotel) VALUES ('Hotel Galaxia', 4, 5);

-- Insertando datos en la tabla 'piscinas'
INSERT INTO piscinas (tamañopiscina, profunidad, idservicio) VALUES (100, 2, 1);
INSERT INTO piscinas (tamañopiscina, profunidad, idservicio) VALUES (150, 2.5, 2);
INSERT INTO piscinas (tamañopiscina, profunidad, idservicio) VALUES (200, 1.8, 3);
INSERT INTO piscinas (tamañopiscina, profunidad, idservicio) VALUES (250, 3, 4);
INSERT INTO piscinas (tamañopiscina, profunidad, idservicio) VALUES (300, 2.2, 5);

-- Insertando datos en la tabla 'planes'
INSERT INTO planes (nombreplan, descripcionplan, tipos_idtipo, servicios_idservicio, idplan) VALUES ('Plan Aventura', 'Aventura y hospedaje', 1, 1, 1);
INSERT INTO planes (nombreplan, descripcionplan, tipos_idtipo, servicios_idservicio, idplan) VALUES ('Plan Relax', 'Spa y descanso', 2, 2, 2);
INSERT INTO planes (nombreplan, descripcionplan, tipos_idtipo, servicios_idservicio, idplan) VALUES ('Plan Cultural', 'Tours culturales y alojamiento', 3, 3, 3);
INSERT INTO planes (nombreplan, descripcionplan, tipos_idtipo, servicios_idservicio, idplan) VALUES ('Plan Gourmet', 'Gastronomía y estancia', 4, 4, 4);
INSERT INTO planes (nombreplan, descripcionplan, tipos_idtipo, servicios_idservicio, idplan) VALUES ('Plan Todo Incluido', 'Disfrute completo sin preocupaciones', 5, 5, 5);

-- Insertando datos en la tabla 'productos'
INSERT INTO productos (nombre, precio, restaurantes_idservicio, bares_idservicio, tiendas_idservicio, idproducto) VALUES ('Cocktail Margarita', 12.00, 1, 1, 1, 1);
INSERT INTO productos (nombre, precio, restaurantes_idservicio, bares_idservicio, tiendas_idservicio, idproducto) VALUES ('Hamburguesa de Res', 15.00, 2, 2, 2, 2);
INSERT INTO productos (nombre, precio, restaurantes_idservicio, bares_idservicio, tiendas_idservicio, idproducto) VALUES ('Bufanda de Seda', 40.00, 3, 3, 3, 3);
INSERT INTO productos (nombre, precio, restaurantes_idservicio, bares_idservicio, tiendas_idservicio, idproducto) VALUES ('Café Americano', 3.00, 4, 4, 4, 4);
INSERT INTO productos (nombre, precio, restaurantes_idservicio, bares_idservicio, tiendas_idservicio, idproducto) VALUES ('Vino Tinto Reserva', 30.00, 5, 5, 5, 5);

-- Insertando datos en la tabla 'reservas'
INSERT INTO reservas (horareserva, idreserva, cuentas_idcuenta) VALUES (TO_DATE('2023-11-05 19:00:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO reservas (horareserva, idreserva, cuentas_idcuenta) VALUES (TO_DATE('2023-11-06 19:00:00', 'YYYY-MM-DD HH24:MI:SS'), 2, 2);
INSERT INTO reservas (horareserva, idreserva, cuentas_idcuenta) VALUES (TO_DATE('2023-11-07 19:00:00', 'YYYY-MM-DD HH24:MI:SS'), 3, 3);
INSERT INTO reservas (horareserva, idreserva, cuentas_idcuenta) VALUES (TO_DATE('2023-11-08 19:00:00', 'YYYY-MM-DD HH24:MI:SS'), 4, 4);
INSERT INTO reservas (horareserva, idreserva, cuentas_idcuenta) VALUES (TO_DATE('2023-11-09 19:00:00', 'YYYY-MM-DD HH24:MI:SS'), 5, 5);

-- Insertando datos en la tabla 'restaurantes'
INSERT INTO restaurantes (estilo, idservicio) VALUES ('Frances', 1);
INSERT INTO restaurantes (estilo, idservicio) VALUES ('Italiano', 2);
INSERT INTO restaurantes (estilo, idservicio) VALUES ('Mediterraneo', 3);
INSERT INTO restaurantes (estilo, idservicio) VALUES ('Mexicano', 4);
INSERT INTO restaurantes (estilo, idservicio) VALUES ('Oriental', 5);

-- Insertando datos en la tabla 'reuniones'
INSERT INTO reuniones (capacidad, costoadicional, fecha, hora, duracion, idservicio) VALUES (30, 150.00, TO_DATE('2023-11-10', 'YYYY-MM-DD'), TO_DATE('10:00:00', 'HH24:MI:SS'), 2, 1);
INSERT INTO reuniones (capacidad, costoadicional, fecha, hora, duracion, idservicio) VALUES (50, 250.00, TO_DATE('2023-11-11', 'YYYY-MM-DD'), TO_DATE('11:00:00', 'HH24:MI:SS'), 3, 2);
INSERT INTO reuniones (capacidad, costoadicional, fecha, hora, duracion, idservicio) VALUES (10, 100.00, TO_DATE('2023-11-12', 'YYYY-MM-DD'), TO_DATE('09:00:00', 'HH24:MI:SS'), 1.5, 3);
INSERT INTO reuniones (capacidad, costoadicional, fecha, hora, duracion, idservicio) VALUES (20, 200.00, TO_DATE('2023-11-13', 'YYYY-MM-DD'), TO_DATE('14:00:00', 'HH24:MI:SS'), 2.5, 4);
INSERT INTO reuniones (capacidad, costoadicional, fecha, hora, duracion, idservicio) VALUES (40, 300.00, TO_DATE('2023-11-14', 'YYYY-MM-DD'), TO_DATE('16:00:00', 'HH24:MI:SS'), 2, 5);

-- Insertando datos en la tabla 'servicios'
INSERT INTO servicios (horarioinicial, horariofinal, nombre, costo, cargado, existe, idservicio, reservas_idreserva) VALUES (TO_DATE('2023-01-01 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-01-01 20:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Servicio de Limpieza', 100.00, 'NO', 'SI', 1, 1);
INSERT INTO servicios (horarioinicial, horariofinal, nombre, costo, cargado, existe, idservicio, reservas_idreserva) VALUES (TO_DATE('2023-01-02 09:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-01-02 18:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Servicio de SPA', 150.00, 'NO', 'SI', 2, 2);
INSERT INTO servicios (horarioinicial, horariofinal, nombre, costo, cargado, existe, idservicio, reservas_idreserva) VALUES (TO_DATE('2023-01-03 10:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-01-03 22:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Servicio de Internet', 50.00, 'SI', 'SI', 3, 3);
INSERT INTO servicios (horarioinicial, horariofinal, nombre, costo, cargado, existe, idservicio, reservas_idreserva) VALUES (TO_DATE('2023-01-04 07:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-01-04 19:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Servicio de Gimnasio', 75.00, 'NO', 'SI', 4, 4);
INSERT INTO servicios (horarioinicial, horariofinal, nombre, costo, cargado, existe, idservicio, reservas_idreserva) VALUES (TO_DATE('2023-01-05 06:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2023-01-05 21:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Servicio de Piscina', 200.00, 'SI', 'SI', 5, 5);

-- Insertando datos en la tabla 'servispas'
INSERT INTO servispas (duracion, costo, fecha, spas_idservicio, idservispas) VALUES (60, 100.00, TO_DATE('2023-11-20', 'YYYY-MM-DD'), 1, 1);
INSERT INTO servispas (duracion, costo, fecha, spas_idservicio, idservispas) VALUES (90, 150.00, TO_DATE('2023-11-21', 'YYYY-MM-DD'), 2, 2);
INSERT INTO servispas (duracion, costo, fecha, spas_idservicio, idservispas) VALUES (120, 200.00, TO_DATE('2023-11-22', 'YYYY-MM-DD'), 3, 3);
INSERT INTO servispas (duracion, costo, fecha, spas_idservicio, idservispas) VALUES (30, 50.00, TO_DATE('2023-11-23', 'YYYY-MM-DD'), 4, 4);
INSERT INTO servispas (duracion, costo, fecha, spas_idservicio, idservispas) VALUES (45, 75.00, TO_DATE('2023-11-24', 'YYYY-MM-DD'), 5, 5);

-- Insertando datos en la tabla 'spas'
INSERT INTO spas (capacidad, idservicio) VALUES (10, 1);
INSERT INTO spas (capacidad, idservicio) VALUES (15, 2);
INSERT INTO spas (capacidad, idservicio) VALUES (20, 3);
INSERT INTO spas (capacidad, idservicio) VALUES (5, 4);
INSERT INTO spas (capacidad, idservicio) VALUES (8, 5);

-- Insertando datos en la tabla 'tiendas'
INSERT INTO tiendas (tipo, idservicio) VALUES ('Joyeria', 1);
INSERT INTO tiendas (tipo, idservicio) VALUES ('Moda', 2);
INSERT INTO tiendas (tipo, idservicio) VALUES ('Souvenirs', 3);
INSERT INTO tiendas (tipo, idservicio) VALUES ('Supermercado', 4);
INSERT INTO tiendas (tipo, idservicio) VALUES ('Joyeria', 5);

-- Insertando datos en la tabla 'tipos'
INSERT INTO tipos (tipo, capacidad, dotacion, idtipo) VALUES ('Doble', 2, '2 camas, baño privado, TV', 1);
INSERT INTO tipos (tipo, capacidad, dotacion, idtipo) VALUES ('Familiar', 4, '4 camas, 2 baños privados, TV, cocina', 2);
INSERT INTO tipos (tipo, capacidad, dotacion, idtipo) VALUES ('Sencilla', 1, '1 cama, baño privado, TV', 3);
INSERT INTO tipos (tipo, capacidad, dotacion, idtipo) VALUES ('Suite', 2, '1 cama grande, jacuzzi, baño privado, TV, sala de estar', 4);
INSERT INTO tipos (tipo, capacidad, dotacion, idtipo) VALUES ('Suite Presidencial', 2, '1 cama king, jacuzzi, baño privado, TV, sala de estar, vista al mar', 5);

-- Insertando datos en la tabla 'usuarios'
INSERT INTO usuarios (nombreuser, tipodocuser, numdocuser, correouser, iduser, alojamientos_idalojamiento) 
VALUES ('Laura Martínez', 'CC', 23456789, 'laura.martinez@example.com', 1, 1),
       ('Carlos Rojas', 'CC', 34567890, 'carlos.rojas@example.com', 2, 2),
       ('Sofia Castro', 'CC', 45678901, 'sofia.castro@example.com', 3, 3),
       ('David Gómez', 'CC', 56789012, 'david.gomez@example.com', 4, 4),
       ('Lucia Fernández', 'CC', 67890123, 'lucia.fernandez@example.com', 5, 5);

-- Insertando datos en la tabla 'utensilios'
INSERT INTO utensilios (devuelto, estado, idservicio) 
VALUES ('NO', 'Nuevo', 1),
       ('SI', 'Usado', 2),
       ('NO', 'Buen estado', 3),
       ('SI', 'Nuevo', 4),
       ('NO', 'Usado', 5);

-- Insertando datos en la tabla 'wifi'
INSERT INTO wifi (anchobanda, idservicio) VALUES (50.0, 1);
INSERT INTO wifi (anchobanda, idservicio) VALUES (75.0, 2);
INSERT INTO wifi (anchobanda, idservicio) VALUES (100.0, 3);
INSERT INTO wifi (anchobanda, idservicio) VALUES (50.0, 4);
INSERT INTO wifi (anchobanda, idservicio) VALUES (25.0, 5);
       