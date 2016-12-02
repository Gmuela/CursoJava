package ejercicio5.familias;

import ejercicio5.Instrumento;

public class Cuerda implements Instrumento {

    private String nombre;

    public Cuerda(String nombre) {
        this.nombre = nombre;
    }

    public String tocar() {
        return "Estoy rascando";
    }

    public String getNombre() {
        return nombre;
    }
}
