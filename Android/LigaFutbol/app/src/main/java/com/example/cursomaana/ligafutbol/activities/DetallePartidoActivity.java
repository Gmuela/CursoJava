package com.example.cursomaana.ligafutbol.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cursomaana.ligafutbol.repositories.DataBasePartidos;
import com.example.cursomaana.ligafutbol.beans.Equipo;
import com.example.cursomaana.ligafutbol.beans.Partido;
import com.example.cursomaana.ligafutbol.R;

public class DetallePartidoActivity extends AppCompatActivity {

    private ImageView imagenEstadio;
    private TextView nombreEstadio;

    private ImageView imagenEquipoLocal;
    private TextView nombreEquipoLocal;
    private TextView estadoEquipoLocal;
    private TextView entrenadorEquipoLocal;

    private ImageView imagenEquipoVisitante;
    private TextView nombreEquipoVisitante;
    private TextView estadoEquipoVisitante;
    private TextView entrenadorEquipoVisitante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detalle_partido);

        Intent lastIntent = getIntent();
        Integer idPartido = lastIntent.getIntExtra("id", 0);
        DataBasePartidos dataBasePartidos = new DataBasePartidos();
        Partido partido = dataBasePartidos.getPartido(idPartido);

        getStadiumInfo(partido);
        getLocalTeamInfo(partido);
        getVisitanteTeamInfo(partido);

    }

    private void getVisitanteTeamInfo(Partido partido) {
        Equipo equipoVisitante = partido.getEquipoVisitante();

        imagenEquipoVisitante = (ImageView) findViewById(R.id.imagen_equipo_visitante);
        imagenEquipoVisitante.setImageResource(equipoVisitante.getIdImagen());

        nombreEquipoVisitante = (TextView) findViewById(R.id.nombre_equipo_visitante);
        nombreEquipoVisitante.setText(equipoVisitante.getNombreEquipo());

        estadoEquipoVisitante = (TextView) findViewById(R.id.estado_equipo_visitante);
        estadoEquipoVisitante.setText(equipoVisitante.getEstado());

        entrenadorEquipoVisitante = (TextView) findViewById(R.id.nombre_entrenador_visitante);
        entrenadorEquipoVisitante.setText(equipoVisitante.getEntrenador());
    }

    private void getStadiumInfo(Partido partido) {
        nombreEstadio = (TextView) findViewById(R.id.nombre_estadio);
        nombreEstadio.setText(partido.getEstadio());

        imagenEstadio = (ImageView) findViewById(R.id.imagen_estadio);
        imagenEstadio.setImageResource(partido.getImagenEstadio());
    }

    private void getLocalTeamInfo(Partido partido) {
        Equipo equipoLocal = partido.getEquipoLocal();

        imagenEquipoLocal = (ImageView) findViewById(R.id.imagen_equipo_local);
        imagenEquipoLocal.setImageResource(equipoLocal.getIdImagen());

        nombreEquipoLocal = (TextView) findViewById(R.id.nombre_equipo_local);
        nombreEquipoLocal.setText(equipoLocal.getNombreEquipo());

        estadoEquipoLocal = (TextView) findViewById(R.id.estado_equipo_local);
        estadoEquipoLocal.setText(equipoLocal.getEstado());

        entrenadorEquipoLocal = (TextView) findViewById(R.id.nombre_entrenador_local);
        entrenadorEquipoLocal.setText(equipoLocal.getEntrenador());
    }
}
