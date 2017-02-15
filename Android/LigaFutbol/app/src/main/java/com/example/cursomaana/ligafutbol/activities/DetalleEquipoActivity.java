package com.example.cursomaana.ligafutbol.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cursomaana.ligafutbol.R;
import com.example.cursomaana.ligafutbol.adapters.AdaptadorJugadores;
import com.example.cursomaana.ligafutbol.beans.Entrenador;
import com.example.cursomaana.ligafutbol.beans.Equipo;
import com.example.cursomaana.ligafutbol.beans.Jugador;
import com.example.cursomaana.ligafutbol.repositories.DataBasePartidos;
import com.example.cursomaana.ligafutbol.repositories.RepositoryFactory;

public class DetalleEquipoActivity extends AppCompatActivity {

    private TextView nombreEquipo;
    private ImageView escudoEquipo;
    private TextView nombreEstadio;
    private ImageView imagenEstadio;
    private TextView nombreEntrenador;
    private ImageView imagenEntrenador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detalle_equipo);

        Intent lastIntent = getIntent();
        int equipo = lastIntent.getIntExtra("equipo", 0);

        DataBasePartidos dataBasePartidos = RepositoryFactory.getInstance();

        Equipo equipoDetalle = dataBasePartidos.getEquipo(equipo);

        getTeamInfo(equipoDetalle);
        getStadiumInfo(equipoDetalle);
        getTrainerInfo(equipoDetalle);
        getPlayersInfo(equipoDetalle);

    }

    private void getTeamInfo(Equipo equipoDetalle) {
        nombreEquipo = (TextView) findViewById(R.id.nombre_equipo);
        escudoEquipo = (ImageView) findViewById(R.id.imagen_escudo);
        nombreEquipo.setText(equipoDetalle.getNombreEquipo());
        escudoEquipo.setImageResource(equipoDetalle.getImagenEscudo());
    }

    private void getStadiumInfo(Equipo equipoDetalle) {
        nombreEstadio = (TextView) findViewById(R.id.nombre_estadio);
        imagenEstadio = (ImageView) findViewById(R.id.imagen_estadio);
        nombreEstadio.setText(equipoDetalle.getNombreEstadio());
        imagenEstadio.setImageResource(equipoDetalle.getImagenEstadio());
    }

    private void getTrainerInfo(Equipo equipoDetalle) {
        final Entrenador entrenador = equipoDetalle.getEntrenador();

        nombreEntrenador = (TextView) findViewById(R.id.nombre_entrenador);
        imagenEntrenador = (ImageView) findViewById(R.id.imagen_entrenador);
        nombreEntrenador.setText(entrenador.getNombre());
        imagenEntrenador.setImageResource(entrenador.getImagen());

        imagenEntrenador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(DetalleEquipoActivity.this, DetallePersonaActivity.class);
                nextIntent.putExtra("persona", entrenador.getId());
                nextIntent.putExtra("isJugador", false);
                startActivity(nextIntent);
            }
        });
    }

    private void getPlayersInfo(Equipo equipoDetalle) {
        Jugador[] jugadores = equipoDetalle.getJugadores();

        AdaptadorJugadores adaptadorJugadores = new AdaptadorJugadores(this,jugadores);

        GridView gridView = (GridView) findViewById(R.id.grid_jugadores);
        gridView.setAdapter(adaptadorJugadores);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Jugador jugadorClickado = (Jugador) parent.getItemAtPosition(position);
                Intent nextIntent = new Intent(DetalleEquipoActivity.this, DetallePersonaActivity.class);
                nextIntent.putExtra("persona", jugadorClickado.getId());
                nextIntent.putExtra("isJugador", true);
                startActivity(nextIntent);
            }
        });
    }
}
