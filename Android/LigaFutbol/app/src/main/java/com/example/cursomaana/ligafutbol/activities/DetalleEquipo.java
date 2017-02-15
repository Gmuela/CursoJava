package com.example.cursomaana.ligafutbol.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.cursomaana.ligafutbol.R;
import com.example.cursomaana.ligafutbol.adapters.AdaptadorJugadores;
import com.example.cursomaana.ligafutbol.beans.Equipo;
import com.example.cursomaana.ligafutbol.beans.Jugador;
import com.example.cursomaana.ligafutbol.repositories.DataBasePartidos;

public class DetalleEquipo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detalle_equipo);

        Intent lastIntent = getIntent();
        int equipo = lastIntent.getIntExtra("equipo", 0);

        DataBasePartidos dataBasePartidos = new DataBasePartidos();

        Equipo equipoDetalle = dataBasePartidos.getEquipo(equipo);

        Jugador[] jugadores = equipoDetalle.getJugadores();

        AdaptadorJugadores adaptadorJugadores = new AdaptadorJugadores(this,jugadores);

        GridView gridView = (GridView) findViewById(R.id.grid_jugadores);
        gridView.setAdapter(adaptadorJugadores);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Jugador jugadorClickado = (Jugador) parent.getItemAtPosition(position);
                Intent nextIntent = new Intent(DetalleEquipo.this, DetalleJugador.class);
                nextIntent.putExtra("jugador", jugadorClickado.getId());
                startActivity(nextIntent);
            }
        });

    }
}
