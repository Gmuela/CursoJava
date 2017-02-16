package com.example.cursomaana.ligafutbol.repositories;

import com.example.cursomaana.ligafutbol.R;
import com.example.cursomaana.ligafutbol.beans.Entrenador;
import com.example.cursomaana.ligafutbol.beans.Equipo;
import com.example.cursomaana.ligafutbol.beans.Estadio;
import com.example.cursomaana.ligafutbol.beans.Jugador;
import com.example.cursomaana.ligafutbol.beans.Partido;

public class DataBasePartidos {

    private Entrenador rui = new Entrenador(1, "Rui Vitória", 40, R.mipmap.entrenador_rui, true);
    private Entrenador thomas = new Entrenador(2, "Thomas Tuchel", 40, R.mipmap.entrenador_thomas, true);
    private Entrenador unai = new Entrenador(3, "Unai Emery", 40, R.mipmap.entrenador_unai, true);
    private Entrenador luis = new Entrenador(4, "Luis Enrique Martínez García", 40, R.mipmap.entrenador_luis, true);
    private Entrenador carlo = new Entrenador(5, "Carlo Ancelotti", 40, R.mipmap.entrenador_carlo, true);
    private Entrenador arsene = new Entrenador(6, "Arsène Wenger", 40, R.mipmap.entrenador_arsene, true);
    private Entrenador zidane = new Entrenador(7, "Zinedine Zidane", 40, R.mipmap.entrenador_zidane, true);
    private Entrenador sarri = new Entrenador(8, "Maurizio Sarri", 40, R.mipmap.entrenador_sarri, true);

    private Jugador ronaldo = new Jugador(1, "Cristiano Ronaldo", 28, R.mipmap.jugador_ronaldo, 7, "Delantero");
    private Jugador benzema = new Jugador(2, "Benzemá", 23, R.mipmap.jugador_benzema, 9, "Delantero");
    private Jugador isco = new Jugador(3, "Men-isco", 20, R.mipmap.jugador_isco, 22, "Centrocampista");
    private Jugador marcelo = new Jugador(4, "Marcelo", 31, R.mipmap.jugador_marcelo, 12, "Defensa");
    private Jugador modric = new Jugador(5, "Modric", 21, R.mipmap.jugador_modric, 19, "Centrocampista");
    private Jugador varane = new Jugador(6, "Varane", 25, R.mipmap.jugador_varane, 5, "Defensa");
    private Jugador navas = new Jugador(7, "Navas", 27, R.mipmap.jugador_navas, 1, "Portero");
    private Jugador ramos = new Jugador(8, "Sergio Ramos", 33, R.mipmap.jugador_ramos, 4, "Defensa central");
    private Jugador kroos = new Jugador(9, "Tony Kroos", 26, R.mipmap.jugador_kroos, 8, "Centrocampista");
    private Jugador lucas = new Jugador(10, "Lucas Vázquez", 20, R.mipmap.jugador_lucas, 17, "Delantero");
    private Jugador casemiro = new Jugador(11, "Casemiro", 19, R.mipmap.jugador_casemiro, 14, "Centrocampista");

    private Jugador[] jugadores = {ronaldo, benzema, isco, marcelo, modric, varane, navas, ramos, kroos, lucas, casemiro};
    private Entrenador[] entrenadores = {rui, thomas, unai, luis, carlo, arsene, zidane, sarri};

    private Estadio estadioBenfica = new Estadio("Estadio da Luz", "https://es.wikipedia.org/wiki/Est%C3%A1dio_da_Luz", R.mipmap.ic_estadio_benfica);
    private Estadio estadioDortmund = new Estadio("Signal Iduna Park", "https://es.wikipedia.org/wiki/Signal_Iduna_Park", R.mipmap.ic_estadio_dortmund);
    private Estadio estadioPSG = new Estadio("Parc des Princess", "https://es.wikipedia.org/wiki/Parc_des_Princes", R.mipmap.ic_estadio_psg);
    private Estadio estadioBarca = new Estadio("Camp Nou", "https://es.wikipedia.org/wiki/Camp_Nou", R.mipmap.ic_estadio_barca);
    private Estadio estadioBayern = new Estadio("Allianz Arena", "https://es.wikipedia.org/wiki/Allianz_Arena", R.mipmap.ic_estadio_bayern);
    private Estadio estadioArsenal = new Estadio("Emirates Stadium", "https://es.wikipedia.org/wiki/Emirates_Stadium", R.mipmap.ic_estadio_arsenal);
    private Estadio estadioMadrid = new Estadio("Santiago Bernabéu", "https://es.wikipedia.org/wiki/Estadio_Santiago_Bernab%C3%A9u", R.mipmap.ic_estadio_madrid);
    private Estadio estadioNapoli = new Estadio("Estadio San Paolo", "https://es.wikipedia.org/wiki/Estadio_San_Paolo", R.mipmap.ic_estadio_napoli);

    private Equipo benfica = new Equipo(1, "Benfica", "Ebrios de la noche anterior", estadioBenfica, rui, jugadores, R.mipmap.ic_benfica, "http://www.slbenfica.pt/");
    private Equipo dortmund = new Equipo(2, "Dortmund", "Motivados", estadioDortmund, thomas, jugadores, R.mipmap.ic_dortmund, "http://www.bvb.de/");

    private Equipo paris = new Equipo(3, "PSG", "En la torre eiffel", estadioPSG, unai, jugadores, R.mipmap.ic_paris, "http://www.psg.fr/es/Accueil/0/Home");
    private Equipo barca = new Equipo(4, "Barça", "Evadiendo impuestos", estadioBarca, luis, jugadores, R.mipmap.ic_barca, "https://www.fcbarcelona.es/");

    private Equipo bayern = new Equipo(5, "Bayern", "Comiendo salchichens grossens", estadioBayern, carlo, jugadores, R.mipmap.ic_bayern, "https://fcbayern.com/us");
    private Equipo arsenal = new Equipo(6, "Arsenal", "Tohmandu el tíh de las twelve", estadioArsenal, arsene, jugadores, R.mipmap.ic_arsenal, "http://www.arsenal.com/home");

    private Equipo madrid = new Equipo(7, "Real Madrid", "Viendo el careto de Ronaldo mientras grita", estadioMadrid, zidane, jugadores, R.mipmap.ic_madrid, "http://www.realmadrid.com/");
    private Equipo napoli = new Equipo(8, "Napoli", "Pesto di queso di questo di esto", estadioNapoli, sarri, jugadores, R.mipmap.ic_napoli, "http://www.sscnapoli.it/prehome/html/index.html");

    private Partido partido1 = new Partido(0, benfica, "14/02", "20:45", dortmund);
    private Partido partido2 = new Partido(1, paris, "14/02", "20:45", barca);

    private Partido partido4 = new Partido(3, madrid, "15/02", "20:45", napoli);
    private Partido partido3 = new Partido(2, bayern, "15/02", "20:45", arsenal);

    private Partido[] partidos = {partido1, partido2, partido3, partido4};
    private Equipo[] equipos = {benfica, dortmund, paris, barca, bayern, arsenal, madrid, napoli};

    public Equipo getEquipo(int id) {
        for (Equipo equipo : equipos) {
            if (equipo.getId() == id) {
                return equipo;
            }
        }
        return null;
    }

    public Jugador getJugador(int id) {
        for (Jugador jugador : jugadores) {
            if (jugador.getId() == id) {
                return jugador;
            }
        }
        return null;
    }

    public Entrenador getEntrenador(int id) {
        for (Entrenador entrenador : entrenadores) {
            if (entrenador.getId() == id) {
                return entrenador;
            }
        }
        return null;
    }

    public void terminarPartidos() {
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
