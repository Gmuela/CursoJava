CREATE TABLE Socios
(num_socio INT(4) PRIMARY KEY, apellidos VARCHAR(14) UNIQUE, telefono CHAR(9) NOT NULL, fecha_alta DATE DEFAULT '2000-01-01', direccion VARCHAR(20), CHECK(cod_postal BETWEEN 28000 AND 28999));

CREATE TABLE Prestamos
(num_prestamo INT(2), num_socio INT(4));



CREATE TABLE Socios
(num_socio INT(4), 
 apellidos VARCHAR(14), 
 telefono CHAR(9), 
 fecha_alta DATE, 
 direccion VARCHAR(20), 
 cod_postal INT(5),
 CONSTRAINT PK_SOCIOS PRIMARY KEY (num_socio),
 CONSTRAINT UQ_APELLIDOS UNIQUE (apellidos),
 CONSTRAINT CK_CODIGO CHECK (codigo_postal BETWEEN 28000 AND 28999)
);

CREATE TABLE Prestamos
(num_prestamo INT(2), 
 num_socio INT(4),
 CONSTRAINT PK_PRESTAMOS PRIMARY KEY (num_prestamo),
 CONSTRAINT FK_PRESTAMOS FOREIGN KEY (num_socio) REFERENCES SOCIOS(num_socio)
);

CREATE TABLE Prestamos
(num_prestamo INT(2), 
 num_socio INT(4),
 CONSTRAINT PK_PRESTAMOS PRIMARY KEY (num_prestamo),
 CONSTRAINT FK_PRESTAMOS FOREIGN KEY (num_socio) 
 REFERENCES SOCIOS(num_socio) 
 ON UPDATE CASCADE 
 ON DELETE SET NULL
);