<?php

function registrarUsuario($formulario,$ficheros){

    $nombre = $formulario['nombre'];
    $email = $formulario['email'];
    $pass = $formulario["pass"];
    $fecha = $formulario["fechaNac"];
    $sexo = $formulario["sexo"];
    $intereses = $formulario["intereses"];
    $nombreImagen = $ficheros["imagen"]["name"];

    $usuarioBuilder = new UsuarioBuilder();

    $usuarioBuilder->build($nombre, $email, $pass, $fecha, $sexo, $intereses, $nombreImagen);

    return $usuarioBuilder->getUsuario();
}

function login($usuario,$password){

    $login = true;

    if($password != $usuario->getPassword()){
        $login = false;
    }

    return $login;
}