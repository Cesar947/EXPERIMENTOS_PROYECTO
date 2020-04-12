INSERT INTO Rol(nombre) VALUES ('ROL_CLIENTE');
INSERT INTO Rol(nombre) VALUES ('ROL_ANUNCIANTE');
INSERT INTO Rol(nombre) VALUES ('ROL_ADMIN');

INSERT INTO Cuenta(contrasena, email, nombre_usuario) VALUES ('$2a$10$YbkpPekA1K9uQvDrJw8N7eRr9wvkWYNLO1BwwboG/JHkEHgqDCwOW', 
'cpizarrollanos@gmail.com', 'Cesar947');

INSERT INTO cuenta_rol VALUES(2, 2);
INSERT INTO cuenta_rol VALUES(2, 1);
INSERT INTO membresia(costo, nombre) VALUES (50, "Gold");

INSERT INTO anunciante(antecedentes_penales, celular, dni, fecha_caducidad, telefono_fijo,
url_contacto, membresia_id) VALUES 
('antecedentes.pdf', '992333745', '76544322', '2020-04-09', '7563322', 'www.facebook.com/C', 1);

INSERT INTO usuario(apellido_materno, apellido_paterno, cuenta_habilitada, departamento,
direccion, distrito, imagen_perfil, nombres, provincia, cuenta_id, anunciante_id)
VALUES
('Llanos', 'Pizarro', 1, 'Lima', 'Av. Zukre 333', 'Magdalena del Mar', 'qgWjsyendiAdnw.jpg', 'César Alejandro', 
'Lima', 2, 1);

INSERT INTO tipo_servicio(descripcion, nombre) 
VALUES('Desde no se que hasta no se cuanto', 'Bienvenido a DOC TOPS');



SELECT * FROM cuenta_rol;
SELECT * FROM Rol;
SELECT * FROM Cuenta;
SELECT * FROM Usuario;
SELECT * FROM membresia;
SELECT * FROM anunciante;