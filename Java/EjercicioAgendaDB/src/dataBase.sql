CREATE TABLE personas
(
  nombre VARCHAR(100) NOT NULL,
  apellidos VARCHAR(100) NOT NULL,
  dni VARCHAR(9) PRIMARY KEY NOT NULL,
  fechaNacimiento VARCHAR(11) NOT NULL,
  telefono VARCHAR(9)
);

INSERT INTO personas(nombre, apellidos, dni, fechaNacimiento, telefono) VALUES ('Paco', 'Ramirez', '000A', '10/09/1990', '918000000');
INSERT INTO personas(nombre, apellidos, dni, fechaNacimiento, telefono) VALUES ('Pepe', 'Campos', '000B', '1/04/1968', '918000001');
INSERT INTO personas(nombre, apellidos, dni, fechaNacimiento, telefono) VALUES ('Sara', 'Lopez', '000C', '23/02/1999', '918000002');