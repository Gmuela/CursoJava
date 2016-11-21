<?php

class SeguidorDAO
{
    //TODO implementar el seguir/dejar de seguir si sobra tiempo

    public function selectAllUsuariosSeguidos($idUsuario)
    {
        $dbConnection = UtilDB::connectTo("redsocial", "root", "");

        $query = $dbConnection->prepare('SELECT nombre, estado, imagenPerfil FROM usuarios WHERE idUsuario IN (SELECT idUsuarioSeguidor FROM seguidores WHERE idUsuario = :idUsuario)');
        $query->bindParam(":idUsuario", $idUsuario);

        $query->execute();

        return $query->fetchAll(PDO::FETCH_ASSOC);

    }
}