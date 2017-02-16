package com.example.cursomaana.ligafutbol.beans;

import android.net.Uri;

public class Equipo {

    private int id;
    private String nombreEquipo;
    private String estado;
    private Estadio estadio;
    private Entrenador entrenador;
    private Jugador[] jugadores;
    private boolean isLocal;
    private int imagenEscudo;
    private String paginaOficial;

    public Equipo(int id, String nombreEquipo, String estado, Estadio estadio, Entrenador entrenador, Jugador[] jugadores, int imagenEscudo, String paginaOficial) {
        this.id = id;
        this.nombreEquipo = nombreEquipo;
        this.estado = estado;
        this.estadio = estadio;
        this.entrenador = entrenador;
        this.jugadores = jugadores;
        this.imagenEscudo = imagenEscudo;
        this.paginaOficial = paginaOficial;
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

    public Estadio getEstadio() {
        return estadio;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Uri getUri(){
        return Uri.parse(paginaOficial);
    }

    public String getPaginaOficial() {
        return paginaOficial;
    }

    public void setPaginaOficial(String paginaOficial) {
        this.paginaOficial = paginaOficial;
    }
}
