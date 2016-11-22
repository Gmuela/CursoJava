<?php
require_once("../../Project/UsuariosController.php");
if(!isset($_SESSION)){
    session_start();
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Red Social</title>
    <link rel="stylesheet" type="text/css" href="../Resources/css/cssExamen.css">
</head>
<body>
<div class="divTitle"><h1 class="indexTitle">PRIV-RAPED</h1></div>
<div class="perfil">
    <?php echo mostrarMiPerfil()?>
    <button class='nuevoEstado' onclick='window.location.href="nuevoEstado.html"'>Cambiar Estado</button>
</div>
<div class="otrosUsuarios">
    <?php echo mostrarUsuarios()?>
</div>
</body>
</html>
