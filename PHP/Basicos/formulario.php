<?php

$errores = array();

function validarFormulario()
{

    $formulario = $_POST;
    $ficheros = $_FILES;

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

function mostrarDatos()
{
    $formulario = $_POST;
    $ficheros = $_FILES;

    move_uploaded_file($ficheros["imagen"]["tmp_name"], "./perfiles/" . $formulario["nombre"].".jpg");

    echo "Nombre: " . $formulario["nombre"] . "<br>";
    echo "Correo electrónico: " . $formulario["email"] . "<br>";
    echo "Contraseña: " . $formulario["pass"] . "<br>";
    echo "Edad: " . $formulario["edad"] . "<br>";

    echo "Sexo: " . $formulario["sexo"] . "<br>";

    echo "Intereses: ";

    foreach ($formulario["intereses"] as $interes) {
        echo $interes . ",";
    }

    echo "Imagen de usuario: <img src='./perfiles/" . $formulario["nombre"].".jpg'>";

    echo "<br>";
}

if (validarFormulario()) {
    echo "Te has registrado satisfactoriamente<br><br>";
    mostrarDatos();
} else {
    foreach ($errores as $error) {
        echo $error . "<br>";
    }
}