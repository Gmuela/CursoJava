<?php
include './functions.php';
?>
<html>
<head>
    <style>
        table, td, tr {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
            padding: 10px;
        }

        tr:nth-child(even) {
            background-color: darkslategray;
        }
    </style>
</head>
<body>
<table>
    <?php
        pintar();
    ?>
</table>
</body>
</html>