package com.example.cursomaana.ligafutbol.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cursomaana.ligafutbol.R;
import com.example.cursomaana.ligafutbol.beans.Jugador;
import com.example.cursomaana.ligafutbol.repositories.DataBasePartidos;

public class DetalleJugador extends AppCompatActivity {

    private ImageView imagenJugador;
    private TextView nombreJugador;
    private TextView dorsalJugador;
    private TextView posicionJugador;
    private TextView edadJugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_jugador);
        Intent lastIntent = getIntent();
        int jugador = lastIntent.getIntExtra("jugador", 0);
        DataBasePartidos dataBasePartidos = new DataBasePartidos();
        Jugador jugadorDetalle = dataBasePartidos.getJugador(jugador);

        imagenJugador = (ImageView) findViewById(R.id.imagen_jugador_detalle);
        nombreJugador = (TextView) findViewById(R.id.nombre_jugador_detalle);
        //dorsalJugador = (TextView) findViewById(R.id.dorsal_jugador_detalle);
        posicionJugador = (TextView) findViewById(R.id.posicion_jugador_detalle);
        edadJugador = (TextView) findViewById(R.id.edad_jugador_detalle);

        imagenJugador.setImageResource(jugadorDetalle.getIdImagen());
        nombreJugador.setText(jugadorDetalle.getNombre());
        //dorsalJugador.setText(jugadorDetalle.getDorsal());
        posicionJugador.setText(jugadorDetalle.getPosicion());
//        edadJugador.setText(jugadorDetalle.getEdad());
    }
}
