<?php
require_once("../../Controller/UsuariosController.php");
session_start();
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Red Social</title>
    <link rel="stylesheet" type="text/css" href="../Resources/css/cssExamen.css">
</head>
<body>
<h1 class="indexTitle">Red Social</h1>
<div class="perfil">
    <?php echo mostrarMiPerfil()?>
    <button class='nuevoEstado' onclick='window.location.href="nuevoEstado.html"'>Cambiar Estado</button>
</div>
<div class="otrosUsuarios">
    <?php echo mostrarUsuarios()?>
</div>
</body>
</html>
