USE EZDEAL_TF;

INSERT INTO rol(nombre) VALUES ('ROL_CLIENTE');
INSERT INTO rol(nombre) VALUES ('ROL_ANUNCIANTE');
INSERT INTO rol(nombre) VALUES ('ROL_ADMIN');
DELETE FROM ROL WHERE ROL_ID > 3;
SELECT * FROM ROL;

INSERT INTO membresia(costo, nombre) VALUES (50, "GOLD");
INSERT INTO membresia(costo, nombre) VALUES (0, "FREE");
DELETE FROM MEMBRESIA WHERE MEMBRESIA_ID > 2;

SELECT * FROM Membresia;
SELECT * FROM Usuario;
SELECT * FROM Anunciante;
SELECT * FROM cuenta;
UPDATE USUARIO SET imagen_perfil = "https://m.guiadelocio.com/var/guiadelocio.com/storage/images/cine/personajes/jim-carrey/4307870-13-esl-ES/jim-carrey.jpg" WHERE usuario_id = 3;
#ALTER TABLE Usuario AUTO_INCREMENT = 1

INSERT INTO tipo_servicio(descripcion, nombre) VALUES("Desde servicio de niñera hasta enseñar trucos","Mascotas");
INSERT INTO tipo_servicio(descripcion, nombre) VALUES("Desde gasfitería hasta decoraciones de casas","Mantenimiento del hogar");
INSERT INTO tipo_servicio(descripcion, nombre) VALUES("Enseñanza en cualquier materia","Enseñanza");
INSERT INTO tipo_servicio(descripcion, nombre) VALUES("Productos hechos a mano bajo demanda", "Manualidades");

SELECT * FROM tipo_servicio;
DELETE FROM TIPO_SERVICIO WHERE TIPO_SERVICIO_ID > 4;

SELECT * FROM servicio;
SELECT * FROM reseña;
INSERT INTO Reseña(contenido,valoracion,cliente_id,servicio_id) VALUES ("Muy buen servicio", 5.0, 2, 1);
INSERT INTO Reseña(contenido,valoracion,cliente_id,servicio_id) VALUES ("Buen servicio", 4.0, 3, 1);
INSERT INTO Reseña(contenido,valoracion,cliente_id,servicio_id) VALUES ("Muy buen servicio", 5.0, 1, 2);
INSERT INTO Reseña(contenido,valoracion,cliente_id,servicio_id) VALUES ("Buen servicio", 4.0, 2, 2);
INSERT INTO Reseña(contenido,valoracion,cliente_id,servicio_id) VALUES ("Muy buen servicio", 5.0, 2, 3);
INSERT INTO Reseña(contenido,valoracion,cliente_id,servicio_id) VALUES ("Muy buen servicio", 5.0, 3, 3);
INSERT INTO Reseña(contenido,valoracion,cliente_id,servicio_id) VALUES ("Servicio Regular", 3.5, 1, 4);
INSERT INTO Reseña(contenido,valoracion,cliente_id,servicio_id) VALUES ("Muy buen servicio", 5.0, 2, 4);
DELETE FROM RESEÑA WHERE RESEÑA_ID > 8;


INSERT INTO solicitud(fecha_pactada,hora_pactada, mensaje, servicio_id, cliente_id) 
VALUES("2020-07-11", "15:00:00", "Quiero que revises la tubería del baño", 2, 2);
UPDATE SOLICITUD SET ESTADO = "Enviada" WHERE servicio_id = 2;
select * from solicitud;
DELETE FROM SOLICITUD WHERE SOLICITUD_ID > 2;
ALTER TABLE SOLICITUD AUTO_INCREMENT = 1;
select * from cita;


DELETE FROM RESEÑA WHERE RESEÑA_ID > 0;
ALTER TABLE RESEÑA AUTO_INCREMENT = 1;
UPDATE SERVICIO SET VALORACION = 0 WHERE SERVICIO_ID > 0;
DELIMITER //
CREATE FUNCTION contarResenas (i BIGINT(20))
RETURNS INT

BEGIN
   DECLARE contador INT;

   SET contador = (SELECT COUNT(r.reseña_id) FROM servicio s JOIN reseña r ON r.servicio_id = s.servicio_id WHERE s.servicio_id = i);

   RETURN contador; 

END//
#Recordar no usar cammelCase en SQL 
DELIMITER $$
CREATE TRIGGER TR_INHABILITARSERVICIO
AFTER INSERT ON RESEÑA
FOR EACH ROW BEGIN
	SET @servicioId = NEW.servicio_id;
	SET @resenasTotales = contarResenas(@servicioId);
    IF @resenasTotales >= 7 THEN
		SET @resenasNegativas = (SELECT COUNT(r.reseña_id) FROM reseña r WHERE r.servicio_id = NEW.servicio_id AND r.valoracion <= 2.5);
		SET @porcentaje = (@resenasNegativas/@resenasTotales)*100; 
		IF @porcentaje >= 75 THEN
			UPDATE servicio s SET s.esta_habilitado = 0 where s.servicio_id = @servicioId;
		END IF;
	END IF;
END$$

DELIMITER $$
CREATE TRIGGER TR_ACTUALIZAR_VALORACION
BEFORE INSERT ON RESEÑA
FOR EACH ROW BEGIN
	SET @resenaId = NEW.reseña_id;
    SET @servicioId = NEW.servicio_id;
	SET @cantidadResenas = (SELECT COUNT(r.reseña_id) FROM reseña r WHERE r.servicio_id = @servicioId GROUP BY r.reseña_id);
    SET @valoracion = (SELECT valoracion FROM servicio WHERE servicio_id = @servicioId);
	SET @nuevaValoracion = (@valoracion*@cantidad + NEW.valoracion)/(@cantidad + 1); 
    UPDATE servicio s SET s.valoracion = @nuevaValoracion where s.servicio_id = @servicioId;
END$$
