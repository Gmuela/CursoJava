package com.example.cursomaana.ligafutbol.beans;

public class Jugador extends Persona {

    private Integer dorsal;
    private String posicion;

    public Jugador(String nombre, Integer edad, int idImagen, Integer dorsal, String posicion) {
        super(nombre, edad, idImagen);
        this.dorsal = dorsal;
        this.posicion = posicion;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}
