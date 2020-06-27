SET GLOBAL time_zone = '+3:00';
SET GLOBAL max_user_connections=100;
use g8cpi41gieq2d2qr;
use ezdeal_pruebas;
/*
INSERT INTO usuario(nombres,apellidos,email,contrasena,direccion,distrito,provincia, telefono_celular, 
telefono_fijo, url_contacto, rol) 
VALUES('César Alejandro', 'Pizarro Llanos', 'cpizarrollanos@gmail.com',
'xdxdxd5000', 'Av. Cacao 305', 'Magdalena del Mar', 'Lima', '987654321',
 '7662341', 'www.facebook.com/c', 'A');
 
 INSERT INTO usuario(nombres,apellidos,email,contrasena,direccion,distrito,provincia, telefono_celular, 
telefono_fijo, url_contacto, rol) 
VALUES('Juanelv Alessandro', 'Salgado Sánchez', 'slayz08@gmail.com',
'xdxdxd5000', 'Av. Cocoa 534', 'Callao', 'Lima', '999983211',
 '7772321', 'www.facebook.com/j', 'C');
 
 INSERT INTO tipo_servicio(descripcion, nombre)
 VALUES('Desde paseos hasta enseñarle trucos a sus mascotas', 'Actividades para mascotas');
 
 INSERT INTO servicio(titulo, descripcion, imagen, esta_habilitado, fecha_publicacion, 
 valor_servicio, anunciante_id, tipo_servicio_id, valoracion)
 VALUES('Paseo deperros', 'Si no tiene tiempo para pasear a sus perritos, no duden en llamarme',
 'ajcnAidwifdnc.jpg', 'Habilitado', curdate(), 60.0, 1, 1, 0);

 
INSERT INTO reseña(contenido, valoracion, cliente_id, servicio_id) VALUES('Eres el mejor paseando perros, él está muy feliz :)',
5.0, 2, 1);
 
select * from reseña;
select * from servicio;
select * from usuario;
select * from tipo_servicio;

INSERT INTO rol(nombre) VALUES("ROLE_CLIENTE");
select * from rol;
*/

------------------------------------
INSERT INTO rol(nombre) VALUES ('ROL_CLIENTE');
INSERT INTO rol(nombre) VALUES ('ROL_ANUNCIANTE');
INSERT INTO rol(nombre) VALUES ('ROL_ADMIN');

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
VALUES('Desde pasear perros hasta amaestramiento de tortugas', 'Actividades para mascotas');


INSERT INTO membresia(costo, nombre) VALUES (18.99, "GOLD");
INSERT INTO membresia(costo, nombre) VALUES (0.00, "GRATUITA");
UPDATE membresia SET costo = 18.99 where membresia_id = 1;

#token cliente: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwZXBpbm8iLCJyb2xlcyI6IlJPTF9DTElFTlRFIiwiaWF0IjoxNTg4NDAzNzY4LCJleHAiOjE1ODg0OTAxNjh9.7mc8YPdQGl_e4Qw0Mqf4ylXFd396GpdP2qySN-qD2SbpJqU50gIMZi_ETMzDG0Mou25k3P6IT_pkVFmQE_AGgw
#token anunciante: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjZXNhcjk0NyIsInJvbGVzIjoiUk9MX0NMSUVOVEUsUk9MX0FOVU5DSUFOVEUiLCJpYXQiOjE1ODg0MDM4MDIsImV4cCI6MTU4ODQ5MDIwMn0.PPjBc1dO-L2KPfTu7xj1Ujb0yz5ePo_aGyXFPZwPHO7_JUd82mpDy9FUyUV8fd8P1TDSLTfxrS2DAf-5MH6Jow
SELECT * FROM cuenta_rol;
SELECT * FROM Rol;
SELECT * FROM cuenta;
SELECT * FROM usuario;
SELECT * FROM membresia;
SELECT * FROM anunciante;
SELECT * FROM tipo_servicio;
select * from servicio;
UPDATE servicio SET descripcion = "Especialista en pasear patos de todo tipo" where servicio_id = 10;

select * from cita;
select * from horario;
select * from reseña;
select * from inconveniente;
select * from solicitud;

UPDATE solicitud SET estado = 'Enviada' WHERE solicitud_id = 9;


/*actualizar el estado de la solicitud 40 a finalizado*/
UPDATE solicitud SET estado = "Finalizado" WHERE solicitud_id = 40;

#Queries facilitadores
UPDATE SERVICIO SET esta_habilitado = 1 WHERE SERVICIO_ID > 0;
UPDATE ANUNCIANTE SET membresia_id = 2 WHERE ANUNCIANTE_ID > 0;

#Para ver que usuario tiene membresía GOLD
SELECT u.usuario_id as 'ID', u.nombres as 'NOMBRE', m.nombre as 'MEMBRESÍA' 
FROM USUARIO u JOIN ANUNCIANTE a on a.anunciante_id = u.anunciante_id
JOIN MEMBRESIA m ON a.membresia_id = m.membresia_id where a.membresia_id = 1;

#Para ver los servicios que son GOLD
SELECT s.servicio_id as 'ID', s.titulo as 'TITULO', m.nombre as 'MEMBRESIA', a.anunciante_id as 'ID ANUNCIANTE', u.usuario_id as 'ID USUARIO'
FROM servicio s JOIN usuario u ON s.anunciante_id = u.usuario_id JOIN anunciante a on a.anunciante_id = u.anunciante_id
JOIN membresia m ON a.membresia_id = m.membresia_id where a.membresia_id = 1;

#Para ver los servicios que son FREE
SELECT s.servicio_id as 'ID', s.titulo as 'TITULO', m.nombre as 'MEMBRESIA', a.anunciante_id as 'ID ANUNCIANTE'
FROM servicio s JOIN usuario u ON s.anunciante_id = u.usuario_id JOIN anunciante a on a.anunciante_id = u.anunciante_id
JOIN membresia m ON a.membresia_id = m.membresia_id where a.membresia_id = 2;

#Para ver la cantidad de reseñas de algun servicio y si esta habilitado o no
SELECT s.servicio_id as 'ID SERVICIO', s.titulo as 'Titulo del servicio', 
COUNT(r.reseña_id) as 'Numero de reseñas', s.esta_habilitado as 'Está habilitado'
FROM reseña r join servicio s on s.servicio_id = r.servicio_id
group by s.servicio_id;

#Para ver qué usuarios tienen membresía GOLD
SELECT u.usuario_id as 'ID_USUARIO', u.nombres as 'Nombre', m.nombre as 'Membresia'
FROM usuario u JOIN anunciante a 
ON u.anunciante_id = a.anunciante_id
JOIN membresia m ON m.membresia_id = a.membresia_id;
#WHERE m.nombre = 'GOLD';

#Para ver qué anunciante tienen membresía FREE
SELECT a.anunciante_id as 'ID_ANUNCIANTE', m.nombre as 'Membresia'
FROM anunciante a JOIN membresia m ON m.membresia_id = a.membresia_id
WHERE m.nombre = 'FREE';

SELECT COUNT(c.cita_id) FROM cita c JOIN solicitud s ON c.solicitud_id = s.solicitud_id 
WHERE s.servicio_id = 1 and s.cliente_id = 3 and c.estado = "Finalizado";



UPDATE ANUNCIANTE SET MEMBRESIA_ID = 2 WHERE ANUNCIANTE_ID = 1;
UPDATE SERVICIO SET ESTA_HABILITADO = 1 WHERE SERVICIO_ID = 2;
select * from reseña WHERE servicio_id = 1;
select * from servicio WHERE servicio_id = 2;
select * from servicio;



select * from horario;

INSERT INTO Reseña(contenido, valoracion, cliente_id, servicio_id)
VALUES ("Eres terrible pero al menos hiciste tu trabajo", 2.4, 3, 2);
INSERT INTO Reseña(contenido, valoracion, cliente_id, servicio_id)
VALUES ("Eres terrible pero al menos hiciste tu trabajo", 2.4, 3, 2);
INSERT INTO Reseña(contenido, valoracion, cliente_id, servicio_id)
VALUES ("Eres terrible pero al menos hiciste tu trabajo", 2.4, 3, 2);
INSERT INTO Reseña(contenido, valoracion, cliente_id, servicio_id)
VALUES ("Eres terrible pero al menos hiciste tu trabajo", 2.4, 3, 2);
INSERT INTO Reseña(contenido, valoracion, cliente_id, servicio_id)
VALUES ("Eres terrible pero al menos hiciste tu trabajo", 2.4, 3, 2);
INSERT INTO Reseña(contenido, valoracion, cliente_id, servicio_id)
VALUES ("Eres terrible pero al menos hiciste tu trabajo", 2.4, 3, 2);





SELECT COUNT(r.reseña_id) FROM Reseña r where r.valoracion < 2.5 and r.servicio_id = 1;

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


