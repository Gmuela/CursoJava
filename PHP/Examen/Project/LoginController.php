<?php

require_once("UtilViews.php");
require_once("UsuarioDAO.php");

function login()
{

    $formulario = $_POST;

    $nombre = $formulario["nombre"];
    $password = $formulario["password"];

    $usuarioDAO = new UsuarioDAO();

    if ($nombre == "" or $password == "") {

        UtilViews::redirigirA("html/errorLogin.html");

    } else {

        $usuario = $usuarioDAO->selectOneUsuario($nombre);

        if ($usuario[0]["password"] != $password) {
            UtilViews::redirigirA("html/errorLogin.html");
        } else {
            session_start();
            $_SESSION["usuario"] = $usuario[0];
            UtilViews::redirigirA("html/redsocial.php");
        }
    }
}

if (!empty($_POST)) {

    login();
}
