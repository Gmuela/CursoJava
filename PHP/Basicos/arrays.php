<?php
$diaSemana = array("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo");

function calendario(){

    $mesesDias = array(
        "Enero" => 31,
        "Febrero" => 28,
        "Marzo" => 31,
        "Abril" => 30,
        "Mayo" => 31,
        "Junio" => 30,
        "Julio" => 31,
        "Agosto" => 31,
        "Septiembre" => 30,
        "Octubre" => 31,
        "Noviembre" => 30,
        "Diciembre" => 31
    );

    $counter = 6;
    $check = true;

    foreach ($mesesDias as $mes => $dia) {

        for ($i = 1; $i <= $dia; $i++) {

            if ($mes == $_POST["Mes"]) {

                if ($check) {
                    if ($counter != 0) {
                        for ($j = 1; $j <= $counter; $j++) {
                            echo "<td></td>";
                        }
                        $check = false;
                    }
                }

                echo "<td>" . $i . "</td>";

                if ($counter == 6) {
                    $counter = 0;
                    echo "</tr><tr>";
                } else {
                    $counter++;
                }
                
                if($i==$dia && $counter!=0){
                    for($j=0;$j<=(6-$counter);$j++){
                        echo "<td></td>";
                    }
                }

            } else {
                if ($counter == 6) {
                    $counter = 0;
                } else {
                    $counter++;
                }
            }
        }
    }
}

?>

<html>
<head>
    <style>
        table, tr, td, th {
            border: 2px solid black;
            border-collapse: collapse;
            text-align: center;
            padding: 10px;
        }

        tr:nth-child(odd) {
            background-color: darkgrey;
        }

        th {
            background-color: darkslategray;
            color: white;
            font-size: 1.6em;
        }

        td {
            font-size: 1.3em;
        }
    </style>
</head>
<body>
<h1>Calendario <?php echo $_POST["Mes"] ?> 2017</h1>
<table>
    <tr>
       <?php
       foreach ($diaSemana as $dia) {
           echo "<th>".$dia."</th>";
       }
       ?>
    </tr>
    <tr><?php
        calendario();
        ?>
</table>
</body>
</html>

