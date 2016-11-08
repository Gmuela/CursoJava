<?php

require_once("Usuario.php");

class UsuarioBuilder
{
    private $usuario;

    public function build($nombre, $email, $password, $fechaNac, $sexo, $intereses, $nombreImagen)
    {
        $usuarioNuevo = new Usuario();
        $usuarioNuevo->setNombre($nombre);
        $usuarioNuevo->setEmail($email);
        $usuarioNuevo->setPassword($password);
        $usuarioNuevo->setFechaNac($fechaNac);
        $usuarioNuevo->setSexo($sexo);
        $usuarioNuevo->setIntereses($intereses);
        $usuarioNuevo->setRutaImagen("./userImages/" . $nombreImagen);

        $this->usuario = $usuarioNuevo;
    }

    public function getUsuario()
    {
        return $this->usuario;
    }

}