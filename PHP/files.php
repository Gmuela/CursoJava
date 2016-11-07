<?PHP
if ($gestor = opendir('./perfiles')) {
    echo "Gestor de directorio: $gestor\n";
    echo "Entradas:\n"; /* Esta es la forma correcta de iterar sobre el directorio. */
    while (false !== ($entrada = readdir($gestor))) {
        echo "$entrada"."<br>";
    }
    closedir($gestor);
}