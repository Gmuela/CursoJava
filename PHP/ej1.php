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
    <tr>
        <?php
        define('TAM', 10);
        for ($i = 1; $i <= 100; $i++) {
            if ($i % TAM == 0) {
                echo "<td>" . $i . "</td></tr><tr>";
            } else {
                echo "<td>" . $i . "</td>";
            }
        }
        ?>
</table>
</body>
</html>