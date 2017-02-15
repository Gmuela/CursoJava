package com.example.cursomaana.ligafutbol.beans;

public class Equipo {

    private int id;
    private String nombreEquipo;
    private String estado;
    private String nombreEstadio;
    private Entrenador entrenador;
    private Jugador[] jugadores;
    private boolean isLocal;
    private int imagenEscudo;
    private int imagenEstadio;

    public Equipo(int id, String nombreEquipo, String estado, String nombreEstadio, Entrenador entrenador, Jugador[] jugadores, int imagenEscudo, int imagenEstadio) {
        this.id = id;
        this.nombreEquipo = nombreEquipo;
        this.estado = estado;
        this.nombreEstadio = nombreEstadio;
        this.entrenador = entrenador;
        this.jugadores = jugadores;
        this.imagenEscudo = imagenEscudo;
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

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean local) {
        isLocal = local;
    }

    public int getImagenEscudo() {
        return imagenEscudo;
    }

    public void setImagenEscudo(int imagenEscudo) {
        this.imagenEscudo = imagenEscudo;
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
