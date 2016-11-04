<?php
function calcula($number)
{
    for ($i = 1; $i <= 4; $i++) {
        echo "<td>" . pow($number, $i) . "</td>";
    }
}

function pintar()
{
    for ($i = 1; $i <= 4; $i++) {
        echo "<tr>";
        calcula($i);
        echo "</tr>";
    }
}

?>