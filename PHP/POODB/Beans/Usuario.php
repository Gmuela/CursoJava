<?php

require_once("UsuarioBuilder.php");

class Usuario
{
    const MAYORIA_EDAD = 18;

    private $nombre;
    private $email;
    private $password;
    private $fechaNac;
    private $sexo;
    private $intereses;
    private $rutaImagen;

    /**CONS&DES**/

    function __construct()
    {
        /**Constructor por defecto**/
    }

    function __destruct()
    {
        /**Destructor por defecto**/
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

    function toString()
    {
        $string = "Nombre: " . $this->nombre . "<br>"
            . "Sexo: " . $this->sexo . "<br>"
            . "Fecha nacimiento: " . $this->fechaNac . "<br>"
            . "Edad: " . $this->checkEdad($this->fechaNac) . "<br>"
            . "Email: " . $this->email . "<br>"
            . "Contraseña: " . $this->password . "<br>"
            . "Intereses: ";

        foreach ($this->intereses as $interes) {
            $string .= $interes . ",";
        };

        $string .= "<br><br>Imagen de usuario:<br> <img src='" . $this->rutaImagen . "'>";

        return $string;
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