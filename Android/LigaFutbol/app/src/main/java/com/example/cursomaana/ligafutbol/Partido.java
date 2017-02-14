package com.example.cursomaana.ligafutbol;

public class Partido {

    private int id;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private String fecha;
    private String hora;
    private String estadio;

    public Partido(int id, Equipo equipoLocal, Equipo equipoVisitante, String fecha, String hora) {
        this.id = id;
        this.equipoLocal = equipoLocal;
        this.fecha = fecha;
        this.hora = hora;
        this.equipoLocal.setLocal(true);
        this.equipoVisitante = equipoVisitante;
        this.equipoVisitante.setLocal(false);
        this.estadio = equipoLocal.getEstadio();
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
}
