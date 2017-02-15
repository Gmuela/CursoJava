package com.example.cursomaana.ligafutbol.beans;

import java.util.List;

public class Equipo {

    private int id;
    private String nombreEquipo;
    private String estado;
    private String nombreEstadio;
    private Entrenador entrenador;
    private List<Jugador> jugadores;
    private boolean isLocal;
    private int idImagen;
    private int imagenEstadio;

    public Equipo(int id, String nombreEquipo, String estado, String nombreEstadio, Entrenador entrenador, List<Jugador> jugadores, int idImagen, int imagenEstadio) {
        this.id = id;
        this.nombreEquipo = nombreEquipo;
        this.estado = estado;
        this.nombreEstadio = nombreEstadio;
        this.entrenador = entrenador;
        this.jugadores = jugadores;
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

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}