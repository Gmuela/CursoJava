package com.example.cursomaana.ligafutbol.beans;

public class Persona {

    private int id;
    private String nombre;
    private Integer edad;
    private int idImagen;

    public Persona(int id, String nombre, Integer edad, int idImagen) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.idImagen = idImagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
