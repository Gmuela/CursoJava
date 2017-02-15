package com.example.cursomaana.ligafutbol.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cursomaana.ligafutbol.R;
import com.example.cursomaana.ligafutbol.beans.Equipo;
import com.example.cursomaana.ligafutbol.beans.Partido;
import com.example.cursomaana.ligafutbol.repositories.DataBasePartidos;
import com.example.cursomaana.ligafutbol.repositories.RepositoryFactory;

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
        Integer partido = lastIntent.getIntExtra("partido", 0);
        DataBasePartidos dataBasePartidos = RepositoryFactory.getInstance();;
        Partido partidoDetalle = dataBasePartidos.getPartido(partido);

        getStadiumInfo(partidoDetalle);
        getLocalTeamInfo(partidoDetalle);
        getVisitanteTeamInfo(partidoDetalle);

    }

    private void getLocalTeamInfo(Partido partido) {

        final Equipo equipoLocal = partido.getEquipoLocal();

        imagenEquipoLocal = (ImageView) findViewById(R.id.imagen_equipo_local);
        imagenEquipoLocal.setImageResource(equipoLocal.getImagenEscudo());

        imagenEquipoLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(DetallePartidoActivity.this, DetalleEquipoActivity.class);
                nextIntent.putExtra("equipo", equipoLocal.getId());
                startActivity(nextIntent);
            }
        });

        nombreEquipoLocal = (TextView) findViewById(R.id.nombre_equipo_local);
        nombreEquipoLocal.setText(equipoLocal.getNombreEquipo());

        estadoEquipoLocal = (TextView) findViewById(R.id.estado_equipo_local);
        estadoEquipoLocal.setText(equipoLocal.getEstado());

        entrenadorEquipoLocal = (TextView) findViewById(R.id.nombre_entrenador_local);
        entrenadorEquipoLocal.setText(equipoLocal.getEntrenador().getNombre());
    }

    private void getVisitanteTeamInfo(final Partido partido) {
        final Equipo equipoVisitante = partido.getEquipoVisitante();

        imagenEquipoVisitante = (ImageView) findViewById(R.id.imagen_equipo_visitante);
        imagenEquipoVisitante.setImageResource(equipoVisitante.getImagenEscudo());

        imagenEquipoVisitante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(DetallePartidoActivity.this, DetalleEquipoActivity.class);
                nextIntent.putExtra("equipo", equipoVisitante.getId());
                startActivity(nextIntent);
            }
        });

        nombreEquipoVisitante = (TextView) findViewById(R.id.nombre_equipo_visitante);
        nombreEquipoVisitante.setText(equipoVisitante.getNombreEquipo());

        estadoEquipoVisitante = (TextView) findViewById(R.id.estado_equipo_visitante);
        estadoEquipoVisitante.setText(equipoVisitante.getEstado());

        entrenadorEquipoVisitante = (TextView) findViewById(R.id.nombre_entrenador_visitante);
        entrenadorEquipoVisitante.setText(equipoVisitante.getEntrenador().getNombre());
    }

    private void getStadiumInfo(Partido partido) {
        nombreEstadio = (TextView) findViewById(R.id.nombre_estadio);
        nombreEstadio.setText(partido.getEstadio());

        imagenEstadio = (ImageView) findViewById(R.id.imagen_estadio);
        imagenEstadio.setImageResource(partido.getImagenEstadio());
    }
}
