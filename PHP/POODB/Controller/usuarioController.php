<?php

require_once("../Model/DAO/UsuarioDAO.php");

function registrarUsuario($formulario, $ficheros)
{

    $nombre = $formulario['nombre'];
    $email = $formulario['email'];
    $pass = $formulario["pass"];
    $fecha = $formulario["fechaNac"];
    $sexo = $formulario["sexo"];

    if (isset($formulario["intereses"])) {
        $intereses = $formulario["intereses"];
    } else {
        $intereses = ["Sin intereses"];
    }

    $nombreImagen = $ficheros["imagen"]["name"];

    $usuarioBuilder = new UsuarioBuilder();

    $usuarioBuilder->build($nombre, $email, $pass, $fecha, $sexo, $intereses, $nombreImagen);

    $usuarioDao = new UsuarioDAO();

    $usuarioDao->insert($usuarioBuilder->getUsuario());

    return $usuarioBuilder->getUsuario();
}

function login($usuario, $password)
{

    $login = true;

    if ($password != $usuario->getPassword()) {
        $login = false;
    }

    return $login;
}

function findUser($nombre)
{
    $usuarioDao = new UsuarioDAO();
    return $usuarioDao->selectAll($nombre);
}

function userTable()
{
    $usuarioDao = new UsuarioDAO();
    return $usuarioDao->selectAllNombreAndImage();
}

function mostrarDatos($datosUsuario)
{
    foreach ($datosUsuario as $dato) {
        for ($i = 0; $i <= (count($dato) - 1); $i++) {
            if ($i == 6) {
                echo "<img src='" . $dato[$i] . "'>";
            } else {
                echo $dato[$i] . "<br>";
            }
        }
    }
}

function mostrarTabla()
{
    $datos = userTable();
    echo "<table><tr>";
    for ($i = 0; $i <= (count($datos) - 1); $i++) {
        if ($i % 4 == 0 AND $i != 0) {
            echo "</tr><tr>";
        }
        echo "<td>" . $datos[$i]["nombre"] . "<br>";
        echo "<img src='" . $datos[$i]["imagen"] . "' style='height: 120px;'></td>";
    }
    echo "</tr></table>";
}
