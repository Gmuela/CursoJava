<?php

require_once("Usuario.php");

$errores = array();
$formulario = $_POST;
$ficheros = $_FILES;
$usuarioNuevo = new Usuario();

function validarFormulario()
{

    global $formulario;
    global $ficheros;

    global $errores;

    $checked = true;

    if ($formulario["nombre"] == null OR $formulario["email"] == null OR $formulario["pass"] == null OR $formulario["fechaNac"] == null) {
        $checked = false;
        array_push($errores, "Los campos no pueden estar vacíos");
    }

    if (strlen($formulario["pass"]) < 6) {
        $checked = false;
        array_push($errores, "La contraseña no puede tener menos de 6 caractéres");
    }

    if (strpos($formulario["email"], "@") == false) {
        $checked = false;
        array_push($errores, "Email no válido(xxx@xxxx)");
    }

    if ($ficheros["imagen"]["size"] > $formulario["MAX_FILE_SIZE"]) {
        $checked = false;
        array_push($errores, "La imagen supera el tamaño permitido(10MB)");
    }
    if ($ficheros["imagen"]["type"] != "image/jpeg") {
        $checked = false;
        array_push($errores, "La imagen no cumple con el formato permitido(.jpg)");
    }

    return $checked;

}

function registrarUsuario(){

    global $formulario;
    global $ficheros;
    global $usuarioNuevo;

    $nombre = $formulario['nombre'];
    $email = $formulario['email'];
    $pass = $formulario["pass"];
    $fecha = $formulario["fechaNac"];
    $sexo = $formulario["sexo"];
    $intereses = $formulario["intereses"];
    $nombreImagen = $ficheros["imagen"]["name"];

    $usuarioBuilder = new UsuarioBuilder();

    $usuarioBuilder->build($nombre, $email, $pass, $fecha, $sexo, $intereses, $nombreImagen);

    $usuarioNuevo = $usuarioBuilder->getUsuario();
}

function login($password){

    global $usuarioNuevo;
    global $errores;

    $login = true;

    if($password != $usuarioNuevo->getPassword()){
        $login = false;
    }

    return $login;
}

function mostrarDatos()
{
    global $usuarioNuevo;

    echo "Nombre: " . $usuarioNuevo->getNombre() . "<br>";
    echo "Correo electrónico: " . $usuarioNuevo->getEmail() . "<br>";
    echo "Contraseña: " . $usuarioNuevo->getPassword() . "<br>";

    echo "Edad: ".checkEdad($usuarioNuevo->getFechaNac()). "<br>";

    echo "Sexo: " . $usuarioNuevo->getSexo() . "<br>";

    echo "Intereses: ";

    $intereses = $usuarioNuevo->getIntereses();
    foreach ($intereses as $interes) {
        echo $interes . ",";
    }

    echo  "<br>";

    echo "Imagen de usuario: <img src='".$usuarioNuevo->getRutaImagen()."'>";

    echo "<br>";

    echo $usuarioNuevo->toString();
}

function checkEdad($fechaNac){

    $anios = substr($fechaNac,0,4);

    $result = 2016-$anios;

    if($result<Usuario::MAYORIA_EDAD){
        $result = "No es mayor de edad";
    }

    return $result;
}

function moveImageTo($carpeta)
{
    global $ficheros;

    move_uploaded_file($ficheros["imagen"]["tmp_name"], "./".$carpeta."/" . $ficheros["imagen"]["name"]);
}

if (validarFormulario()) {
    registrarUsuario();
    moveImageTo("userImages");

    echo "Te has registrado satisfactoriamente<br><br>";

    if(login("123456")){
        echo "Login correcto<br><br>";
    } else{
        echo "Login incorrecto<br><br>";
    }

    mostrarDatos();
} else {
    foreach ($errores as $error) {
        echo $error . "<br>";
    }
}