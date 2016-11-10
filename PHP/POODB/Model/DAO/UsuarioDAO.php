<?php

require_once("UtilDB.php");

class UsuarioDAO
{

    function __construct()
    {

    }

    function __destruct()
    {
    }

    public function insert($usuario)
    {

        $dbConnection = UtilDB::connectTo("practica", "root", "");
        $query = $dbConnection->prepare('INSERT INTO usuarios(nombre, email, pass, fechaNac, sexo, intereses, imagen) 
                                        VALUES(:nombre, :email, :pass, :fechaNac, :sexo, :intereses, :rutaImagen)');

        $query->bindParam(":nombre", $usuario->getNombre());
        $query->bindParam(":email", $usuario->getEmail());
        $query->bindParam(":pass", $usuario->getPassword());
        $query->bindParam(":fechaNac", $usuario->getFechaNac());
        $query->bindParam(":sexo", $usuario->getSexo());

        $intereses = implode(",",$usuario->getIntereses());

        $query->bindParam(":intereses", $intereses);
        $query->bindParam(":rutaImagen", $usuario->getRutaImagen());

        $query->execute();

    }

    public function selectAll($nombre)
    {
        $dbConnection = UtilDB::connectTo("practica", "root", "");
        $query = $dbConnection->prepare('SELECT * FROM usuarios WHERE usuarios.nombre = :nombre');

        $query->bindParam(":nombre",$nombre);

        $query->execute();

        return $query->fetchAll(PDO::FETCH_NUM);

    }

    public function selectAllNombreAndImage(){
        $dbConnection = UtilDB::connectTo("practica", "root", "");
        $query = $dbConnection->prepare('SELECT nombre,imagen FROM usuarios');

        $query->execute();

        return $query->fetchAll(PDO::FETCH_ASSOC);
    }
}