<?php

require_once("UsuarioDAO.php");
require_once("SeguidorDAO.php");

function mostrarMiPerfil(){

    $profile = "";

    $usuario = $_SESSION["usuario"];

    $imagen = $usuario["imagenPerfil"];
    $profile .= "<img src='$imagen'>";

    $profile .= "<div class='datosPerfil'><span class='cabeceraDato'>Nombre de usuario:</span> ".$usuario["nombre"]."</div>";

    $profile .= "<div class='datosPerfil'><span class='cabeceraDato'>Estado Actual:</span> ".$usuario["estado"]."</div>";

    return $profile;
}

function mostrarUsuarios(){

    $usuarios = "";

    $usuario = $_SESSION["usuario"];

    $seguidoresDAO = new SeguidorDAO();

    $seguidos = $seguidoresDAO->selectAllUsuariosSeguidos($usuario["idUsuario"]);

    foreach($seguidos as $user){
        $usuarios .= "<div class='usuarioSeguido'>";
        $usuarios .= "<div><img class='imagenSeguido' src='".$user["imagenPerfil"]."'></div>";
        $usuarios .= "<div class='nombreSeguido'>".$user["nombre"]."</div>";
        $usuarios .= "<div class='estadoSeguido'>".$user["estado"]."</div>";
        $usuarios .= "</div>";
    }

    return $usuarios;

}

function nuevoEstado(){



}

if(isset($_POST["nuevoEstado"])){
    nuevoEstado();
}