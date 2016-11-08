<?php
function conectarMySQL($schema="practica", $user="root", $pwd="", $host="localhost"){
    try{

        $dsn="mysql:host=$host;dbname=$schema";
        $db=new PDO($dsn,$user,$pwd);
        return $db;
    }
    catch (PDOException $e){
        echo "Error en la conexión".$e;
        die();
    }
}