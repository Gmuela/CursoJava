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

        $dbConnection = UtilDB::connectTo("redsocial", "root", "");
        $query = $dbConnection->prepare('INSERT INTO usuarios(nombre, imagenPerfil, password, estado) 
                                        VALUES(:nombre, :imagenPerfil, :pass, :estado)');

        $query->bindParam(":nombre", $usuario->getNombre());
        $query->bindParam(":imagenPerfil", $usuario->getImagenPerfil());
        $query->bindParam(":pass", $usuario->getPassword());
        $query->bindParam(":estado", $usuario->getEstado());

        $query->execute();

    }

    public function selectAllUsuarios()
    {
        $dbConnection = UtilDB::connectTo("redsocial", "root", "");
        $query = $dbConnection->prepare('SELECT * FROM usuarios');

        $query->execute();

        return $query->fetchAll(PDO::FETCH_ASSOC);

    }

    public function selectOneUsuario($nombre){
        $dbConnection = UtilDB::connectTo("redsocial", "root", "");
        $query = $dbConnection->prepare('SELECT * FROM usuarios WHERE usuarios.nombre= :nombre');

        $query->bindParam(":nombre", $nombre);

        $query->execute();

        return $query->fetchAll(PDO::FETCH_ASSOC);
    }

    public function updateEstado($nombre, $estado){
        $dbConnection = UtilDB::connectTo("redsocial", "root", "");
        $query = $dbConnection->prepare('UPDATE usuarios SET estado = :estado WHERE nombre= :nombre');

        $query->bindParam(":nombre", $nombre);
        $query->bindParam(":estado", $estado);

        $query->execute();
    }
}