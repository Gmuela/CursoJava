package com.example.cursomaana.ligafutbol.beans;

public class Persona {

    private String nombre;
    private Integer edad;
    private int idImagen;

    public Persona(String nombre, Integer edad, int idImagen) {
        this.nombre = nombre;
        this.edad = edad;
        this.idImagen = idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }
}
