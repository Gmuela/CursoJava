package com.example.cursomaana.ligafutbol.beans;

public class Partido {

    private int id;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private String fecha;
    private String hora;
    private String estadio;
    private int imagenEstadio;
    private boolean jugado;
    private String resultado;

    public Partido(int id, Equipo equipoLocal, String fecha, String hora, Equipo equipoVisitante) {

        this.id = id;

        this.equipoLocal = equipoLocal;
        this.equipoLocal.setLocal(true);
        this.fecha = fecha;
        this.hora = hora;
        this.equipoVisitante = equipoVisitante;
        this.equipoVisitante.setLocal(false);

        this.estadio = equipoLocal.getNombreEstadio();
        this.imagenEstadio = equipoLocal.getImagenEstadio();
        this.jugado = false;
        this.resultado="No jugado";
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(Equipo equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(Equipo equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagenEstadio() {
        return imagenEstadio;
    }

    public void setImagenEstadio(int imagenEstadio) {
        this.imagenEstadio = imagenEstadio;
    }

    public boolean isJugado() {
        return jugado;
    }

    public void setJugado(boolean jugado) {
        this.jugado = jugado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
