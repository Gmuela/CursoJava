<?php

class Usuario
{
    private $nombre;
    private $email;
    private $password;
    private $fechaNac;
    private $sexo;
    private $intereses;
    private $rutaImagen;
    const MAYORIA_EDAD = 18;

    /**BUILDER**/

    public function build($nombre, $email, $password, $fechaNac, $sexo, $intereses, $nombreImagen){
        $usuarioNuevo = new Usuario();
        $usuarioNuevo->setNombre($nombre);
        $usuarioNuevo->setEmail($email);
        $usuarioNuevo->setPassword($password);
        $usuarioNuevo->setFechaNac($fechaNac);
        $usuarioNuevo->setSexo($sexo);
        $usuarioNuevo->setIntereses($intereses);
        $usuarioNuevo->setRutaImagen("./userImages".$nombreImagen.".jpg");

        return $usuarioNuevo;
    }

    /**CONS&DES**/

    function __construct()
    {

    }

    function __destruct()
    {

    }

    /**GETTERS**/

    public function getNombre()
    {
        return $this->nombre;
    }

    public function getEmail()
    {
        return $this->email;
    }


    public function getFechaNac()
    {
        return $this->fechaNac;
    }


    public function getIntereses()
    {
        return $this->intereses;
    }


    public function getPassword()
    {
        return $this->password;
    }

    public function getSexo()
    {
        return $this->sexo;
    }

    public function getRutaImagen()
    {
        return $this->rutaImagen;
    }

    /**SETTERS**/

    public function setNombre($nombre)
    {
        $this->nombre = $nombre;
    }

    public function setEmail($email)
    {
        $this->email = $email;
    }

    public function setFechaNac($fechaNac)
    {
        $this->fechaNac = $fechaNac;
    }

    public function setIntereses($intereses)
    {
        $this->intereses = $intereses;
    }

    public function setPassword($password)
    {
        $this->password = $password;
    }

    public function setSexo($sexo)
    {
        $this->sexo = $sexo;
    }

    public function setRutaImagen($rutaImagen)
    {
        $this->rutaImagen = $rutaImagen;
    }
}