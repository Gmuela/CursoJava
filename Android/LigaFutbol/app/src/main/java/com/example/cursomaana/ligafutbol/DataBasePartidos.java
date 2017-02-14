package com.example.cursomaana.ligafutbol;

public class DataBasePartidos {

    int imagenEstadio = R.mipmap.ic_estadio;

    private Equipo benfica = new Equipo("Benfica", "Ebrios de la noche anterior", "Estadio da Luz", "Rui Vitória", R.mipmap.ic_benfica, imagenEstadio);
    private Equipo dortmund = new Equipo("Dortmund", "Motivados", "Signal Iduna Park", "Thomas Tuchel", R.mipmap.ic_dortmund, imagenEstadio);

    private Equipo paris = new Equipo("PSG", "En la torre eiffel", "Parc des Princes", "Unai Emery", R.mipmap.ic_paris, imagenEstadio);
    private Equipo barca = new Equipo("Barça", "Evadiendo impuestos", "Camp Nou", "Luis Enrique Martínez García", R.mipmap.ic_barca, imagenEstadio);

    private Equipo bayern = new Equipo("Bayern", "Comiendo salchichens grossens", "Allianz Arena", "Carlo Ancelotti", R.mipmap.ic_bayern, imagenEstadio);
    private Equipo arsenal = new Equipo("Arsenal", "Tohmandu el tíh de las twelve", "Emirates Stadium", "Arsène Wenger", R.mipmap.ic_arsenal, imagenEstadio);

    private Equipo madrid = new Equipo("Real Madrid", "Viendo el careto de Ronaldo mientras grita", "Estadio Santiago Bernabéu", "Zinedine Zidane", R.mipmap.ic_madrid, imagenEstadio);
    private Equipo napoli = new Equipo("Napoli", "Pesto di queso di questo di esto", "Estadio San Paolo", "Maurizio Sarri", R.mipmap.ic_napoli, imagenEstadio);

    private Partido partido1 = new Partido(0, benfica, dortmund, "14/02", "20:45");
    private Partido partido2 = new Partido(1, paris, barca, "14/02", "20:45");
    private Partido partido3 = new Partido(2, bayern, arsenal, "15/02", "20:45");
    private Partido partido4 = new Partido(3, madrid, napoli, "15/02", "20:45");


    private Partido[] partidos = new Partido[4];

    public Partido[] getPartidos() {
        partidos[0]=partido1;
        partidos[1]=partido2;
        partidos[2]=partido3;
        partidos[3]=partido4;
        return partidos;
    }

    public Partido getPartido(int id){

        Partido partidoToReturn = null;

        for (Partido partido : partidos) {
            if(partido.getId() == id){
                partidoToReturn = partido;
            }
        }

        return partidoToReturn;
    }
}
