CREATE DATABASE prevencion;
USE prevencion;

-- Tabla "Usuarios"
CREATE TABLE usuario (
 id INT PRIMARY KEY AUTO_INCREMENT,
 nombre VARCHAR(50) NOT NULL,
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

INSERT INTO usuario (nombre, username, password)
VALUES ('Usuario Administrador', 'admin', '1234');

INSERT INTO usuario (nombre, apellido, username, password)
VALUES
('Juan Pérez', 'Pérez', 'juanzito', 'abc123'),
('María González', 'González', 'mariag', '123abc'),
('Pedro Sánchez', 'Sánchez', 'pedros', 'aaa111'),
('Luisa Rodríguez', 'Rodríguez', 'luisar', 'bbb222'),
('Andrés López', 'López', 'andresl', 'aba333'),
('Carolina Martínez', 'Martínez', 'carom', '2121ab'),
('Daniel Silva', 'Silva', 'danis', '321bca'),
('Laura Ramírez', 'Ramírez', 'laurar', 'a1a1a1'),
('Sergio Morales', 'Morales', 'sergiom', '2b2b2b');




INSERT INTO administrativo (run, nombre, apellido, correo, area, usuario_id)
SELECT '11111111-1', 'Juan', 'Pérez', 'juan.perez@correo.com', 'Administración', id
FROM usuario
WHERE username = 'juanzito'
LIMIT 1;

INSERT INTO administrativo (run, nombre, apellido, correo, area, usuario_id)
SELECT '22222222-2', 'María', 'González', 'maria.gonzalez@correo.com', 'Recursos Humanos', id
FROM usuario
WHERE username = 'mariag'
LIMIT 1;

INSERT INTO administrativo (run, nombre, apellido, correo, area, usuario_id)
SELECT '33333333-3', 'Pedro', 'Sánchez', 'pedro.sanchez@correo.com', 'Finanzas', id
FROM usuario
WHERE username = 'pedros'
LIMIT 1;


INSERT INTO profesional (run, nombre, apellido, correo, telefono, cargo, usuario_id)
SELECT '44444444-4', 'Luisa', 'Rodriguez', 'luisa.rodriguez@correo.com', '854465236', 'Electrico', id
FROM usuario
WHERE username = 'luisar'
LIMIT 1;

INSERT INTO profesional (run, nombre, apellido, correo, telefono, cargo, usuario_id)
SELECT '55555555-5', 'Andrés', 'Lopez', 'andres.lopez@correo.com', '987654321', 'Informatico', id
FROM usuario
WHERE username = 'andresl'
LIMIT 1;

INSERT INTO profesional (run, nombre, apellido, correo, telefono, cargo, usuario_id)
SELECT '66666666-6', 'Carolina', 'Martínez', 'carolina.martinez@correo.com', '654321987', 'Analista', id
FROM usuario
WHERE username = 'carom'
LIMIT 1;


INSERT INTO cliente (rut, nombre, apellido, correo, telefono, afp, sistema_salud, direccion, comuna, edad, usuario_id)
SELECT '77777777-7', 'Daniel', 'Silva', 'daniel.silva@correo.com', '654321987', 'AFP1', 'isapre', 'Las rosas 13', 'Valparaiso', 30, id
FROM usuario
WHERE username = 'danis'
LIMIT 1;

INSERT INTO cliente (rut, nombre, apellido, correo, telefono, afp, sistema_salud, direccion, comuna, edad, usuario_id)
SELECT '88888888-8', 'Laura', 'Ramírez', 'laura.ramirez@correo.com', '951753852', 'AFP2', 'fonasa', 'camelias 55', 'Quilpue', 35, id
FROM usuario
WHERE username = 'laurar'
LIMIT 1;

INSERT INTO cliente (rut, nombre, apellido, correo, telefono, afp, sistema_salud, direccion, comuna, edad, usuario_id)
SELECT '99999999-9', 'Sergio', 'Moralez', 'sergio.morales@correo.com', '444555222', 'AFP3', 'isapre', 'av quinta 654', 'Concon', 40, id
FROM usuario
WHERE username = 'sergiom'
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
