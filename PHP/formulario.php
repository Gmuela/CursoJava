<?php

$errores=array();

function validarFormulario(){

    $formulario = $_POST;

    global $errores;

    $checked=true;

    if($formulario["nombre"]==null OR $formulario["email"]==null OR $formulario["pass"]==null OR $formulario["edad"]==null){
        $checked=false;
        array_push($errores, "Los campos no pueden estar vacíos");
    }

    if(strlen($formulario["pass"])<6){
        $checked=false;
        array_push($errores, "La contraseña no puede tener menos de 6 caractéres");
    }

    if($formulario["edad"]<1 OR $formulario["edad"]>120 OR is_nan($formulario["edad"])){
        $checked=false;
        array_push($errores, "Edad no válida(1-120)");
    }

    if(strpos($formulario["email"],"@")==false){
        $checked=false;
        array_push($errores, "Email no válido(xxx@xxxx)");
    }

    return $checked;

}

function mostrarDatos(){
    $formulario = $_POST;

    echo "Nombre: ".$formulario["nombre"]."<br>";
    echo "Correo electrónico: ".$formulario["email"]."<br>";
    echo "Contraseña: ".$formulario["pass"]."<br>";
    echo "Edad: ".$formulario["edad"]."<br>";

    echo "Sexo: ".$formulario["sexo"]."<br>";

    echo "Intereses: ";

    foreach ($formulario["intereses"] as $interes) {
        echo $interes.",";
    }

    echo "<br>";
}

if(validarFormulario()){
    echo "Te has registrado satisfactoriamente<br><br>";
    mostrarDatos();
}

else{
    foreach ($errores as $error) {
        echo $error."<br>";
    }
}