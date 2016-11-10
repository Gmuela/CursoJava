<?php

require_once("../Beans/Usuario.php");
require_once("./usuarioController.php");

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

function checkEdad($fechaNac)
{
    $fechaDate = new DateTime($fechaNac);
    $hoy = new DateTime();

    $result = $fechaDate->diff($hoy);
    $result = $result->format('%y');

    if ($result < Usuario::MAYORIA_EDAD) {
        $result = "No es mayor de edad";
    }

    return $result;
}

function moveImageTo($carpeta)
{
    global $ficheros;

    move_uploaded_file($ficheros["imagen"]["tmp_name"], $carpeta . $ficheros["imagen"]["name"]);
}

function callView()
{

    global $errores;
    global $formulario;
    global $ficheros;

    if (validarFormulario()) {
        $usuarioNuevo = registrarUsuario($formulario, $ficheros);
        moveImageTo("../View/Resources/userImages/");

        echo "<br><br><h1>---------------------------------ÚLTIMO REGISTRO--------------------------------</h1><br><br>";

        echo "Te has registrado satisfactoriamente<br><br>";

        if (login($usuarioNuevo, "123456")) {
            echo "Login correcto<br><br>";
        } else {
            echo "Login incorrecto<br><br>";
        }

        $user = findUser($usuarioNuevo->getNombre());
        mostrarDatos($user);
        echo "<br><br><h1>---------------------------------TABLA USUARIOS--------------------------------</h1><br><br>";
        mostrarTabla();
    } else {
        foreach ($errores as $error) {
            echo $error . "<br>";
        }
    }

}

callView();
