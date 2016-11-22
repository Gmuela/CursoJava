<?php

class UtilViews
{

    public static function redirigirA($vista)
    {
        header('Location: http://localhost/php/Examen/Views/' . $vista);
    }
}

