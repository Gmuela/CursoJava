CREATE DATABASE IF NOT EXISTS redsocial;
USE redsocial;
DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS seguidores;

--
-- TABLA USUARIOS
--

CREATE TABLE usuarios (
  idUsuario INT(10) PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(35),
  imagenPerfil VARCHAR(200),
  password VARCHAR(25),
  estado VARCHAR(250)
);

CREATE TABLE seguidores (
  idUsuario INT(10),
  idUsuarioSeguidor INT(10),
  CONSTRAINT fk_idUsuario FOREIGN KEY (idUsuario)
    REFERENCES usuarios(idUsuario)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT fk_idUsuarioSeguidor FOREIGN KEY (idUsuarioSeguidor)
    REFERENCES usuarios(idUsuario)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT
);

--
-- USUARIO GUILLERMO idUsuario 1
--
INSERT INTO usuarios(nombre, imagenPerfil, password, estado)
VALUES (
  'Guillermo',
  '../Resources/ImgUsers/imagenGuillermo.png',
  '123456',
  'Hoy es un buen día :D'
);

--
-- USUARIO MARIA idUsuario 2
--
INSERT INTO usuarios(nombre, imagenPerfil, password, estado)
VALUES (
  'Maria',
  '../Resources/ImgUsers/imagenMaria.png',
  '123456',
  'Lluvia <3'
);

--
-- USUARIO ROCKO idUsuario 3
--
INSERT INTO usuarios(nombre, imagenPerfil, password, estado)
VALUES (
  'Rocko',
  '../Resources/ImgUsers/imagenRocko.png',
  '123456',
  'Miau!'
);

--
-- USUARIO BRUNO idUsuario 4
--
INSERT INTO usuarios(nombre, imagenPerfil, password, estado)
VALUES (
  'Bruno',
  '../Resources/ImgUsers/imagenBruno.png',
  '123456',
  'Otra vez me he mordido!!!'
);

--
-- USUARIO MARIJOSE
--
INSERT INTO usuarios(nombre, imagenPerfil, password, estado)
VALUES (
  'Marijose',
  '../Resources/ImgUsers/imagenMarijose.png',
  '123456',
  'Sia <3<3<3'
);

--
-- GUILLERMO(ID 1) SIGUE A TODOS
--
INSERT INTO seguidores(idUsuario, idUsuarioSeguidor)
VALUES (1,2);
INSERT INTO seguidores(idUsuario, idUsuarioSeguidor)
VALUES (1,3);
INSERT INTO seguidores(idUsuario, idUsuarioSeguidor)
VALUES (1,4);
INSERT INTO seguidores(idUsuario, idUsuarioSeguidor)
VALUES (1,5);
