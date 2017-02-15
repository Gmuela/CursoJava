package com.example.cursomaana.ligafutbol.repositories;

import com.example.cursomaana.ligafutbol.beans.Equipo;
import com.example.cursomaana.ligafutbol.beans.Partido;
import com.example.cursomaana.ligafutbol.R;

public class DataBasePartidos {

    private Equipo benfica = new Equipo("Benfica", "Ebrios de la noche anterior", "Estadio da Luz", "Rui Vitória", R.mipmap.ic_benfica, R.mipmap.ic_estadio_benfica);
    private Equipo dortmund = new Equipo("Dortmund", "Motivados", "Signal Iduna Park", "Thomas Tuchel", R.mipmap.ic_dortmund, R.mipmap.ic_estadio_dortmund);

    private Equipo paris = new Equipo("PSG", "En la torre eiffel", "Parc des Princes", "Unai Emery", R.mipmap.ic_paris, R.mipmap.ic_estadio_psg);
    private Equipo barca = new Equipo("Barça", "Evadiendo impuestos", "Camp Nou", "Luis Enrique Martínez García", R.mipmap.ic_barca, R.mipmap.ic_estadio_barca);

    private Equipo bayern = new Equipo("Bayern", "Comiendo salchichens grossens", "Allianz Arena", "Carlo Ancelotti", R.mipmap.ic_bayern, R.mipmap.ic_estadio_bayern);
    private Equipo arsenal = new Equipo("Arsenal", "Tohmandu el tíh de las twelve", "Emirates Stadium", "Arsène Wenger", R.mipmap.ic_arsenal, R.mipmap.ic_estadio_arsenal);

    private Equipo madrid = new Equipo("Real Madrid", "Viendo el careto de Ronaldo mientras grita", "Estadio Santiago Bernabéu", "Zinedine Zidane", R.mipmap.ic_madrid, R.mipmap.ic_estadio_madrid);
    private Equipo napoli = new Equipo("Napoli", "Pesto di queso di questo di esto", "Estadio San Paolo", "Maurizio Sarri", R.mipmap.ic_napoli, R.mipmap.ic_estadio_napoli);

    private Partido partido1 = new Partido(0, benfica, "14/02", "20:45", dortmund);
    private Partido partido2 = new Partido(1, paris, "14/02", "20:45", barca);
    private Partido partido3 = new Partido(2, bayern, "15/02", "20:45", arsenal);
    private Partido partido4 = new Partido(3, madrid, "15/02", "20:45", napoli);

    private Partido[] partidos = {partido1,partido2,partido3,partido4};

    public void terminarPartidos(){
        partido1.setJugado(true);
        partido1.setResultado("1 - 0");
        partido2.setJugado(true);
        partido2.setResultado("4 - 0");
    }

    public Partido[] getPartidos() {
        terminarPartidos();
        return partidos;
    }

    public Partido getPartido(int id) {
        for (Partido partido : partidos) {
            if (partido.getId() == id) {
                return partido;
            }
        }
        return null;
    }
}
