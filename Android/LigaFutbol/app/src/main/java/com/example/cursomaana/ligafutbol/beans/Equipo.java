package com.example.cursomaana.ligafutbol.beans;

public class Equipo {

    private String nombreEquipo;
    private String estado;
    private String nombreEstadio;
    private String entrenador;
    private boolean isLocal;
    private int idImagen;
    private int imagenEstadio;

    public Equipo(String nombreEquipo, String estado, String nombreEstadio, String entrenador, int idImagen, int imagenEstadio) {
        this.nombreEquipo = nombreEquipo;
        this.estado = estado;
        this.nombreEstadio = nombreEstadio;
        this.entrenador = entrenador;
        this.idImagen = idImagen;
        this.imagenEstadio = imagenEstadio;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreEstadio() {
        return nombreEstadio;
    }

    public void setNombreEstadio(String nombreEstadio) {
        this.nombreEstadio = nombreEstadio;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public int getImagenEstadio() {
        return imagenEstadio;
    }

    public void setImagenEstadio(int imagenEstadio) {
        this.imagenEstadio = imagenEstadio;
    }
}
