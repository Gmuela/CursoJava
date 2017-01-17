CREATE TABLE usuarios
(
  nombre VARCHAR(100) NOT NULL PRIMARY KEY ,
  email VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL
);

INSERT INTO usuarios(nombre, email, password) VALUES ('admin', 'admin@admin.com', 'admin');

CREATE TABLE contactos
(
id INT(99) NOT NULL PRIMARY KEY AUTO_INCREMENT,
nombre VARCHAR(100) NOT NULL,
apellidos VARCHAR(100) NOT NULL,
dni VARCHAR(9) NOT NULL,
fechaNacimiento VARCHAR(11) NOT NULL,
telefono VARCHAR(9),
nombre_usuario VARCHAR(100) NOT NULL,
CONSTRAINT fk_usuario FOREIGN KEY (nombre_usuario)
  REFERENCES usuarios(nombre)
);

INSERT INTO contactos(nombre, apellidos, dni, fechaNacimiento, telefono, nombre_usuario) VALUES ('Paco', 'Ramirez', '000A', '10/09/1990', '918000000', 'admin');
INSERT INTO contactos(nombre, apellidos, dni, fechaNacimiento, telefono, nombre_usuario) VALUES ('Pepe', 'Campos', '000B', '1/04/1968', '918000001', 'admin');
INSERT INTO contactos( nombre, apellidos, dni, fechaNacimiento, telefono, nombre_usuario) VALUES ('Sara', 'Lopez', '000C', '23/02/1999', '918000002', 'admin');

