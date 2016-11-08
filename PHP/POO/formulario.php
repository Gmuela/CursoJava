<?php

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

    if ($formulario["nombre"] == null OR $formulario["email"] == null OR $formulario["pass"] == null OR $formulario["edad"] == null) {
        $checked = false;
        array_push($errores, "Los campos no pueden estar vacíos");
    }

    if (strlen($formulario["pass"]) < 6) {
        $checked = false;
        array_push($errores, "La contraseña no puede tener menos de 6 caractéres");
    }

    if ($formulario["edad"] < 1 OR $formulario["edad"] > 120 OR is_nan($formulario["edad"])) {
        $checked = false;
        array_push($errores, "Edad no válida(1-120)");
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
    $fecha = $formulario["fecha"];
    $sexo = $formulario["sexo"];
    $intereses = $formulario["intereses"];
    $nombreImagen = $ficheros["imagen"]["name"];

    $usuarioNuevo->build($nombre, $email, $pass, $fecha, $sexo, $intereses, $nombreImagen);
}

function mostrarDatos()
{
    global $usuarioNuevo;

    echo "Nombre: " . $usuarioNuevo->getNombre() . "<br>";
    echo "Correo electrónico: " . $usuarioNuevo->getEmail() . "<br>";
    echo "Contraseña: " . $usuarioNuevo->getPassword() . "<br>";

    echo checkEdad($usuarioNuevo->getFechaNac());

    echo "Sexo: " . $usuarioNuevo->getSexo() . "<br>";

    echo "Intereses: ";

    foreach ($usuarioNuevo->getIntereses() as $interes) {
        echo $interes . ",";
    }

    echo "Imagen de usuario: <img src='".$usuarioNuevo->getRutaImagen()."'>";

    echo "<br>";
}

function checkEdad($fechaNac){
    $anios = substr($fechaNac,0,3);
    var_dump($anios);
    return "Hola";
}

function moveImageTo($carpeta)
{
    global $ficheros;
    global $formulario;

    move_uploaded_file($ficheros["imagen"]["tmp_name"], "./".$carpeta."/" . $formulario["nombre"] . ".jpg");
}

if (validarFormulario()) {
    registrarUsuario();
    moveImageTo("userImages");

    echo "Te has registrado satisfactoriamente<br><br>";
    mostrarDatos();
} else {
    foreach ($errores as $error) {
        echo $error . "<br>";
    }
}