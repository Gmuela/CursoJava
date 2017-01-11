package Servlets;

public interface UtilHTML {
    String TEXT_HTML = "text/html";
    String DOCTYPE = "<!DOCTYPE html>";
    String HTML = "<html lang='en'>";
    String TITLE = "<title>JContacts</title>";
    String CSS_TABLE = "<link rel='stylesheet' type='text/css' href='/Resources/cssTable.css' />";
    String CSS = "<link rel='stylesheet' type='text/css' href='/Resources/css.css' />";
    String HEAD = "<head><meta charset='UTF-8'>" + TITLE + CSS + CSS_TABLE + "</head>";
    String BODY = "<body>";
    String CLOSE_BODY = "</body>";
    String CLOSE_HTML = "</html>";
    String BR = "<br>";
    String TABLE = "<table>";
    String TR = "<tr>";
    String TD = "<td>";
    String CLOSE_TABLE = "</table>";
    String CLOSE_TR = "</tr>";
    String CLOSE_TD = "</td>";
    String BUTTON_REMOVE = "<div class='botones'><button type='submit' class='myButton' name='button' value='remove'>Borrar</button></div>";
    String BUTTON_UPDATE = "<div class='botones'><button type='submit' class='myButton' name='button' value='update'>Modificar</button></div>";
    String FORM_UPDATE_REMOVE = "<form action='/contactos' method='post'>";
    String CLOSE_FORM = "</form>";
    String BUTTON_ADD = "<a href='Agenda/addContacto.html'><div class='botones'><button class='myButton'>Añadir</button></div></a>";
    String TODOS = "<option value='/00/' selected>Todos</options>";
    String ENERO = "<option value='/01/'>Enero</options>";
    String FEBRERO = "<option value='/02/'>Febrero</options>";
    String MARZO = "<option value='/03/'>Marzo</options>";
    String ABRIL = "<option value='/04/'>Abril</options>";
    String MAYO = "<option value='/05/'>Mayo</options>";
    String JUNIO = "<option value='/06/'>Junio</options>";
    String JULIO = "<option value='/07/'>Julio</options>";
    String AGOSTO = "<option value='/08/'>Agosto</options>";
    String SEPTIEMBRE = "<option value='/09/'>Septiembre</options>";
    String OCTUBRE = "<option value='/10/'>Octubre</options>";
    String NOVIEMBRE = "<option value='/11/'>Noviembre</options>";
    String DICIEMBRE = "<option value='/12/'>Diciembre</options>";
    String OPTIONS = TODOS + ENERO + FEBRERO + MARZO + ABRIL + MAYO + JUNIO + JULIO + AGOSTO + SEPTIEMBRE + OCTUBRE + NOVIEMBRE + DICIEMBRE;
    String BUTTON_FILTER = "<div class='botones'><button type='submit' class='myButton' name='button' value='filter'>Filtrar</button></div>";
    String SELECT_MONTH = "<div><form action='/contactos' method='post'><select name='mes'>" + OPTIONS + "</select>" + BUTTON_FILTER + "</form></div>";

}
