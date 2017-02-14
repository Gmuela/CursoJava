package com.example.cursomaana.ligafutbol;

public class Equipo {

    private String nombreEquipo;
    private String estado;
    private String estadio;
    private String entranador;
    private boolean isLocal;
    private int idImagen;
    private int imagenEstadio;

    public Equipo(String nombreEquipo, String estado, String estadio, String entranador, int idImagen, int imagenEstadio) {
        this.nombreEquipo = nombreEquipo;
        this.estado = estado;
        this.estadio = estadio;
        this.entranador = entranador;
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

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    public String getEntranador() {
        return entranador;
    }

    public void setEntranador(String entranador) {
        this.entranador = entranador;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }
}
