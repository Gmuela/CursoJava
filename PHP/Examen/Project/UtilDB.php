<?php

class UtilDB
{
    public static function connectTo($schema, $user, $pwd)
    {
        try {
            $host = "localhost";
            $dsn = "mysql:host=$host;dbname=$schema";
            $db = new PDO($dsn, $user, $pwd);
            return $db;
        } catch (PDOException $e) {
            echo "Error en la conexión" . $e;
            die();
        }
    }
}