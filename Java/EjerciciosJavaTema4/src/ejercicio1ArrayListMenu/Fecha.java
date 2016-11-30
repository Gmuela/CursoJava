package ejercicio1ArrayListMenu;

public class Fecha {

    private String dia;
    private String mes;
    private String anio;

    public Fecha(String fecha) {
        String[] fechaSeparada = fecha.split("/");
        this.dia = fechaSeparada[0];
        this.mes = fechaSeparada[1];
        this.anio = fechaSeparada[2];
    }

    public String toString() {
        String info;
        info = dia + "/" + mes + "/" + anio;
        return info;
    }

    public String getDia() {
        return dia;
    }

    public String getMes() {
        return mes;
    }

    public String getAnio() {
        return anio;
    }
}
