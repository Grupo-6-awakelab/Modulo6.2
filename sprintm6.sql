CREATE DATABASE sprintm6;
USE sprintm6;

-- Tabla "Usuarios"
CREATE TABLE usuario (
 id INT PRIMARY KEY AUTO_INCREMENT,
 role VARCHAR(20) NOT NULL,
 username varchar(100) not null,
 password varchar(500) not null
);

CREATE TABLE administrativo (
  id int primary key AUTO_INCREMENT,
  run varchar(11) not null,
  nombre VARCHAR(50) not null,
  apellido varchar(50) not null,
  correo varchar(100) not null,
  area varchar(100),
  usuario_id int,
  FOREIGN key (usuario_id) REFERENCES usuario(id)
);

	create table cliente (
	  id int primary key AUTO_INCREMENT,
	  rut varchar(11) not null,
	  nombre VARCHAR(50) not null,
	  apellido varchar(50) not null,
	  correo varchar(100) not null,
	  telefono varchar(20) not null,
	  afp varchar(50),
	  sistema_salud enum('isapre', 'fonasa'),
	  direccion varchar(100),
	  comuna varchar(50),
	  edad smallint,
	  usuario_id int,
	  FOREIGN key (usuario_id) REFERENCES usuario(id)
	);

create table profesional (
  id int primary key AUTO_INCREMENT,
  run varchar(11) not null,
  nombre VARCHAR(50) not null,
  apellido varchar(50) not null,
  correo varchar(100) not null,
  telefono varchar(20) not null,
  cargo varchar(50),
  usuario_id int,
  FOREIGN key (usuario_id) REFERENCES usuario(id)
);

-- Tabla "Capacitaciones"
CREATE TABLE capacitacion (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  detalle TEXT,
  fecha date,
  hora time,
  lugar varchar(500),
  duracion float,
  cantidad int,
  cliente_id int,
  foreign key (cliente_id) references cliente(id)
);

-- Tabla "Visitas"
CREATE TABLE visita (
  id INT PRIMARY KEY AUTO_INCREMENT,
  cliente_id INT,
  fecha DATE,
  hora time,
  lugar varchar(500),
  realizado boolean,
  detalle TEXT,
  profesional_id INT,
  FOREIGN KEY (cliente_id) REFERENCES cliente(id),
  FOREIGN KEY (profesional_id) REFERENCES profesional(id)
);

-- Tabla "Chequeos"
CREATE TABLE chequeo (
  id INT PRIMARY KEY AUTO_INCREMENT,
  visita_id INT,
  detalle TEXT,
  estado ENUM('Pendiente', 'Completado'),
  FOREIGN KEY (visita_id) REFERENCES visita(id)
);

-- Tabla "Pagos"
CREATE TABLE pago (
  id INT PRIMARY KEY AUTO_INCREMENT,
  cliente_id INT,
  monto DECIMAL(10,2),
  fecha_pago DATE,
  FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

-- Tabla "Asesorias"
CREATE TABLE asesoria (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  detalle TEXT,
  profesional_id INT,
  cliente_id int,
  FOREIGN KEY (profesional_id) REFERENCES profesional(id),
  foreign key (cliente_id) references cliente(id)
);

-- Tabla "Accidentes"
CREATE TABLE accidente (
  id INT PRIMARY KEY AUTO_INCREMENT,
  cliente_id INT,
  fecha_accidente DATE,
  detalle TEXT,
  FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

-- Tabla "Asistentes"
CREATE TABLE asistente (
  capacitacion_id INT,
  usuario_id INT,
  FOREIGN KEY (capacitacion_id) REFERENCES capacitacion(id),
  FOREIGN KEY (usuario_id) REFERENCES usuario(id),
  PRIMARY KEY (capacitacion_id, usuario_id)
);

INSERT INTO usuario (role, username, password)
VALUES ('ADMIN', 'admin', '$2a$12$ECjGeH4Y9KRn2.8WZ1M8e.rXzUdfiTTVuRpVEL6jAzus.JkNsABke'),
('CLIENTE', 'danielsilva','$2a$12$dQvm0RQvBZpCVoy3zOciBuU9GaHXTRCStfgrF5Hnvuir8rtE2QGGq'),
('PROFESIONAL','juanperez','$2a$12$q09p47uGSS6D9faankwkm.GfGmeG3mjdtXsaU2YN3bciAkrZdpEAC'),
('CLIENTE', 'lauraramirez', '$2a$12$I/qjHm1s.GgvMAE.nK.9e.rlr0C0.xanpfSjQaqVl7.HQwDGXQ1F2'),
('CLIENTE', 'sergiomoralez','$2a$12$Ksh2QNA.57ZTQANkC0I37OIPbbxkM9T0DtffITD5QM1KebxNk3l/O');


INSERT INTO cliente (rut, nombre, apellido, correo, telefono, afp, sistema_salud, direccion, comuna, edad, usuario_id)
SELECT '77777777-7', 'Daniel', 'Silva', 'daniel.silva@correo.com', '654321987', 'AFP1', 'isapre', 'Las rosas 13', 'Valparaiso', 30, id
FROM usuario
WHERE username = 'danielsilva'
LIMIT 1;

INSERT INTO cliente (rut, nombre, apellido, correo, telefono, afp, sistema_salud, direccion, comuna, edad, usuario_id)
SELECT '88888888-8', 'Laura', 'Ramírez', 'laura.ramirez@correo.com', '951753852', 'AFP2', 'fonasa', 'camelias 55', 'Quilpue', 35, id
FROM usuario
WHERE username = 'lauraramirez'
LIMIT 1;

INSERT INTO cliente (rut, nombre, apellido, correo, telefono, afp, sistema_salud, direccion, comuna, edad, usuario_id)
SELECT '99999999-9', 'Sergio', 'Moralez', 'sergio.morales@correo.com', '444555222', 'AFP3', 'isapre', 'av quinta 654', 'Concon', 40, id
FROM usuario
WHERE username = 'sergiomoralez'
LIMIT 1;

INSERT INTO capacitacion (nombre, detalle, fecha, hora, lugar, duracion, cantidad, cliente_id)
VALUES
('Capacitación para Daniel Silva', 'Detalles de la capacitación para Daniel Silva', '2023-07-22', '09:00:00', 'Sala 1', 150, 20, 1);

INSERT INTO capacitacion (nombre, detalle, fecha, hora, lugar, duracion, cantidad, cliente_id)
VALUES
('Capacitación para Laura Ramírez', 'Detalles de la capacitación para Laura Ramírez', '2023-08-05', '14:30:00', 'Salón A', 180, 15, 2);

INSERT INTO capacitacion (nombre, detalle, fecha, hora, lugar, duracion, cantidad, cliente_id)
VALUES
('Capacitación para Sergio Morales', 'Detalles de la capacitación para Sergio Morales', '2023-09-10', '10:00:00', 'Centro de Eventos', 240, 30, 3);

INSERT INTO profesional (run, nombre, apellido, correo, telefono, cargo, usuario_id)
VALUES
('1111111-1', 'Jose', 'perez', 'joseperez@correo.cl', '686868686', 'informatico', '3');

INSERT INTO asesoria (nombre, detalle, profesional_id, cliente_id)
VALUES
('Prevension', 'prevension de traslado', '1', '1');
