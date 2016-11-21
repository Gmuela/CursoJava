<?php

require_once("UsuarioDAO.php");
require_once("SeguidorDAO.php");
require_once("UtilViews.php");
require_once("Usuarios.php");
session_start();
function mostrarMiPerfil()
{

    $profile = "";

    $usuario = $_SESSION["usuario"];

    $imagen = $usuario["imagenPerfil"];
    $profile .= "<img src='$imagen'>";

    $profile .= "<div class='datosPerfil'><span class='cabeceraDato'>Nombre de usuario:</span> " . $usuario["nombre"] . "</div>";

    $profile .= "<div class='datosPerfil'><span class='cabeceraDato'>Estado Actual:</span> " . $usuario["estado"] . "</div>";

    return $profile;
}

function mostrarUsuarios()
{

    $usuarios = "";

    $usuario = $_SESSION["usuario"];

    $seguidoresDAO = new SeguidorDAO();

    $seguidos = $seguidoresDAO->selectAllUsuariosSeguidos($usuario["idUsuario"]);

    foreach ($seguidos as $user) {
        $usuarios .= "<div class='usuarioSeguido'>";
        $usuarios .= "<div><img class='imagenSeguido' src='" . $user["imagenPerfil"] . "'></div>";
        $usuarios .= "<div class='nombreSeguido'>" . $user["nombre"] . "</div>";
        $usuarios .= "<div class='estadoSeguido'>" . $user["estado"] . "</div>";
        $usuarios .= "</div>";
    }

    return $usuarios;

}

function nuevoEstado()
{

    $nombreUsuario = $_SESSION["usuario"]["nombre"];
    $estado = $_POST["nuevoEstado"];

    $usuarioDAO = new UsuarioDAO();
    $usuarioDAO->updateEstado($nombreUsuario, $estado);

    $usuario = $usuarioDAO->selectOneUsuario($nombreUsuario);
    $_SESSION["usuario"] = $usuario[0];

    UtilViews::redirigirA("html/redsocial.php");

}

function registrarUsuario()
{

    $formulario = $_POST;
    $ficheros = $_FILES;

    $nuevoUsuario = new Usuarios();

    if (empty($formulario["nombre"]) or empty($formulario["password"])) {
        UtilViews::redirigirA("html/errorRegistro.html");
    }

    if (moverFicheros($ficheros, $formulario, $nuevoUsuario)) {
        $usuarioDAO = new UsuarioDAO();
        $nuevoUsuario->setNombre($formulario["nombre"]);
        $nuevoUsuario->setPassword($formulario["password"]);
        $usuarioDAO->insert($nuevoUsuario);
        UtilViews::redirigirA("html/registroCompletado.html");
    } else {
        UtilViews::redirigirA("html/errorRegistro.html");
    }
}

function moverFicheros($ficheros, $formulario, $nuevoUsuario)
{
    $result = "";

    $dir_archivo = '../Views/Resources/ImgUsers/';
    $imagen = $dir_archivo . $_FILES['imagenPerfil']['name'];

    $extension1 = pathinfo($imagen, PATHINFO_EXTENSION);

    $archivo_subido = $dir_archivo . "imagen" . $formulario["nombre"] . "." . $extension1;
    $nuevoUsuario->setImagenPerfil($archivo_subido);
    $result = move_uploaded_file($ficheros["imagenPerfil"]["tmp_name"], $archivo_subido);

    return $result;
}

if (isset($_POST["nuevoEstado"])) {
    nuevoEstado();
}

if (isset($_POST["registro"])) {
    registrarUsuario();
}