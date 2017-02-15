package com.example.cursomaana.ligafutbol.beans;

public class Entrenador extends Persona {

    private boolean isEntrenador;

    public Entrenador(int id, String nombre, Integer edad, int idImagen, boolean isEntrenador) {
        super(id, nombre, edad, idImagen);
        this.isEntrenador = isEntrenador;
    }

    public boolean isEntrenador() {
        return isEntrenador;
    }

    public void setEntrenador(boolean entrenador) {
        isEntrenador = entrenador;
    }
}
