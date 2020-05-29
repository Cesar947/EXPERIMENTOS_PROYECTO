USE ezdeal_testing;

INSERT INTO Rol(nombre) VALUES ('ROL_CLIENTE');
INSERT INTO Rol(nombre) VALUES ('ROL_ANUNCIANTE');
INSERT INTO Rol(nombre) VALUES ('ROL_ADMIN');

INSERT INTO Cuenta(contrasena, email, nombre_usuario) VALUES ('$2a$10$YbkpPekA1K2143124wer9wvkWYNLO1BwwboG/JHkEHgqDCwOW', 
'cpizanos@gmail.com', 'Cesar947');
INSERT INTO Cuenta(contrasena, email, nombre_usuario) VALUES ('$2a$10$YbkpPekA1K2143124wer9wvkWYNLO1BwwboG/JHkEHgqDCwOW', 
'cpiza@gmail.com', 'gaa947');

INSERT INTO cuenta_rol VALUES(1, 1);
INSERT INTO cuenta_rol VALUES(1, 2);
INSERT INTO cuenta_rol VALUES(2, 1);
INSERT INTO cuenta_rol VALUES(2, 2);
INSERT INTO membresia(costo, nombre) VALUES (60.00, "GOLD");
INSERT INTO membresia(costo, nombre) VALUES (0.00, "GRATUITA");

INSERT INTO anunciante(antecedentes_penales, celular, dni, fecha_caducidad, telefono_fijo,
url_contacto, membresia_id) VALUES 
('antecedentes.pdf', '992333745', '76544322', '2020-04-09', '7563322', 'www.facebook.com/2C', 2);

INSERT INTO anunciante(antecedentes_penales, celular, dni, fecha_caducidad, telefono_fijo,
url_contacto, membresia_id) VALUES 
('antecedentes.pdf', '992333745', '76544322', '2020-04-09', '7563322', 'www.facebook.com/2Ceee', 1);

INSERT INTO usuario(apellido_materno, apellido_paterno, cuenta_habilitada, departamento,
direccion, distrito, imagen_perfil, nombres, provincia, cuenta_id, anunciante_id, strikes)
VALUES
('Llanos', 'Perez', 1, 'Lima', 'Av. Zucre 333', 'Magdalena del Mar', 'qgWjsyendiAdnw.jpg', 'César', 
'Lima', 1, 1, 0);
INSERT INTO usuario(apellido_materno, apellido_paterno, cuenta_habilitada, departamento,
direccion, distrito, imagen_perfil, nombres, provincia, cuenta_id, anunciante_id, strikes)
VALUES
('Llanos', 'Perez', 1, 'Lima', 'Av. Zucre 333', 'Magdalena del Mar', 'qgWjsyendiAdnw.jpg', 'César', 
'Lima', 2, 2, 0);


INSERT INTO tipo_servicio(descripcion, nombre) 
VALUES('Desde pasear perros hasta amaestramiento de tortugas', 'Actividades para mascotas');

INSERT INTO Servicio(costo_servicio, descripcion, esta_habilitado, fecha_publicacion,imagen,modalidad,titulo,valoracion,video_presentacion,anunciante_id,tipo_servicio_id)
VALUES (60.00,"Te paseo a tu igüana",1, curdate(), "dsgfsadgds.jpg",1, "Servicio 1", 0.0, "asdgsadgsad.mp4", 1,1);
INSERT INTO Servicio(costo_servicio, descripcion, esta_habilitado, fecha_publicacion,imagen,modalidad,titulo,valoracion,video_presentacion,anunciante_id,tipo_servicio_id)
VALUES (60.00,"Te paseo a tu igüana",1, curdate(), "dsgfsadgds.jpg",1, "Servicio 2", 0.0, "asdgsadgsad.mp4", 2,1);
INSERT INTO Servicio(costo_servicio, descripcion, esta_habilitado, fecha_publicacion,imagen,modalidad,titulo,valoracion,video_presentacion,anunciante_id,tipo_servicio_id)
VALUES (60.00,"Te paseo a tu igüana",1, curdate(), "dsgfsadgds.jpg",1, "Servicio 3", 0.0, "asdgsadgsad.mp4", 1,1);
INSERT INTO Servicio(costo_servicio, descripcion, esta_habilitado, fecha_publicacion,imagen,modalidad,titulo,valoracion,video_presentacion,anunciante_id,tipo_servicio_id)
VALUES (60.00,"Te paseo a tu igüana",1, curdate(), "dsgfsadgds.jpg",1, "Servicio 4", 0.0, "asdgsadgsad.mp4", 2,1);
INSERT INTO Servicio(costo_servicio, descripcion, esta_habilitado, fecha_publicacion,imagen,modalidad,titulo,valoracion,video_presentacion,anunciante_id,tipo_servicio_id)
VALUES (60.00,"Te paseo a tu igüana",1, curdate(), "dsgfsadgds.jpg",1, "Servicio 5", 0.0, "asdgsadgsad.mp4", 1,1);
INSERT INTO Servicio(costo_servicio, descripcion, esta_habilitado, fecha_publicacion,imagen,modalidad,titulo,valoracion,video_presentacion,anunciante_id,tipo_servicio_id)
VALUES (60.00,"Te paseo a tu igüana",1, curdate(), "dsgfsadgds.jpg",1, "Servicio 8", 0.0, "asdgsadgsad.mp4", 2,1);

INSERT INTO horario(dia,hora_apertura,hora_cierre,servicio_id) VALUES("Lunes", "7:00:00", "21:00:00", 1);
INSERT INTO horario(dia,hora_apertura,hora_cierre,servicio_id) VALUES("Martes", "7:00:00", "21:00:00", 2);
INSERT INTO horario(dia,hora_apertura,hora_cierre,servicio_id) VALUES("Miercoles", "7:00:00", "21:00:00", 3);
INSERT INTO horario(dia,hora_apertura,hora_cierre,servicio_id) VALUES("Jueves", "7:00:00", "21:00:00", 4);
INSERT INTO horario(dia,hora_apertura,hora_cierre,servicio_id) VALUES("Viernes", "7:00:00", "21:00:00", 5);
INSERT INTO horario(dia,hora_apertura,hora_cierre,servicio_id) VALUES("Sabado", "7:00:00", "21:00:00", 6);

SELECT * FROM cuenta_rol;
SELECT * FROM Rol;
SELECT * FROM Cuenta;
SELECT * FROM Usuario;
SELECT * FROM membresia;
SELECT * FROM anunciante;
SELECT * FROM tipo_servicio;
select * from servicio;
select * from reseña WHERE servicio_id = 1;
select * from horario;


INSERT INTO Reseña(contenido, valoracion, cliente_id, servicio_id)
VALUES ("Estoy satisfecho aunque la actitud del trabajador no me gustó mucho", 4, 2, 1);
INSERT INTO Reseña(contenido, valoracion, cliente_id, servicio_id)
VALUES ("Eres terrible pero al menos hiciste tu trabajo", 2.4, 2, 1);
INSERT INTO Reseña(contenido, valoracion, cliente_id, servicio_id)
VALUES ("Eres terrible pero al menos hiciste tu trabajo", 2.4, 2, 1);
INSERT INTO Reseña(contenido, valoracion, cliente_id, servicio_id)
VALUES ("Eres terrible pero al menos hiciste tu trabajo", 2.4, 2, 1);
INSERT INTO Reseña(contenido, valoracion, cliente_id, servicio_id)
VALUES ("Eres terrible pero al menos hiciste tu trabajo", 2.4, 2, 1);
INSERT INTO Reseña(contenido, valoracion, cliente_id, servicio_id)
VALUES ("Eres terrible pero al menos hiciste tu trabajo", 2.4, 2, 1);


SELECT COUNT(r.reseña_id) FROM Reseña r where r.valoracion < 2.5 and r.servicio_id = 1;

DELIMITER //
CREATE FUNCTION contarResenas (i BIGINT(20))
RETURNS INT

BEGIN
   DECLARE contador INT;

   SET contador = (SELECT COUNT(r.reseña_id) FROM servicio s JOIN reseña r ON r.servicio_id = s.servicio_id WHERE s.servicio_id = i);

   RETURN contador; 

END//

DELIMITER $$
CREATE TRIGGER TR_INHABILITARSERVICIO
AFTER INSERT ON RESEÑA
FOR EACH ROW BEGIN
	SET @servicioId = NEW.servicio_id;
	SET @resenasTotales = contarResenas(@servicioId);
    IF @resenasTotales >= 7 THEN
		SET @resenasNegativas = (SELECT COUNT(r.reseña_id) FROM reseña r WHERE r.servicio_id = NEW.servicio_id AND r.valoracion < 2.5);
		SET @porcentaje = (@resenasNegativas/@resenasTotales)*100; 
		IF @porcentaje >= 75 THEN
			UPDATE servicio s SET s.esta_habilitado = 0 where s.servicio_id = @servicioId;
		END IF;
	END IF;
END$$