SET GLOBAL time_zone = '+3:00';
use ezdeal_pruebas;

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
