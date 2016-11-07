<?php
function mostrarDatos()
{
    $contador= 0;
    if ($gestor = opendir('./perfiles')) {
        while (false !== ($entrada = readdir($gestor))) {
            if($entrada != "." AND $entrada != ".."){
                echo "<td>".substr($entrada,0,strpos($entrada,"."))."<img src='./perfiles/".$entrada."'></td>";
                $contador++;
            }

            if ($contador==4) {
                $contador=0;
                echo "</tr><tr>";
            }
        }
        closedir($gestor);
    }
}

?>

<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>Fotos</title>
    <link rel="stylesheet" href="css.css" type="text/css">
</head>
<body>
<table>
    <tr><?php mostrarDatos() ?>
</table>
</body>
</html>
