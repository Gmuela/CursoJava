package com.example.cursomaana.ligafutbol.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cursomaana.ligafutbol.R;
import com.example.cursomaana.ligafutbol.beans.Entrenador;
import com.example.cursomaana.ligafutbol.beans.Jugador;
import com.example.cursomaana.ligafutbol.repositories.DataBasePartidos;
import com.example.cursomaana.ligafutbol.repositories.RepositoryFactory;

public class DetallePersonaActivity extends AppCompatActivity {

    private ImageView imagenJugador;
    private TextView nombreJugador;
    private TextView dorsalJugador;
    private TextView posicionJugador;
    private TextView edadJugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detalle_persona);

        imagenJugador = (ImageView) findViewById(R.id.imagen_jugador_detalle);
        nombreJugador = (TextView) findViewById(R.id.nombre_jugador_detalle);
        dorsalJugador = (TextView) findViewById(R.id.dorsal_jugador_detalle);
        posicionJugador = (TextView) findViewById(R.id.posicion_jugador_detalle);
        edadJugador = (TextView) findViewById(R.id.edad_jugador_detalle);

        Intent lastIntent = getIntent();

        int persona = lastIntent.getIntExtra("persona", 0);
        boolean isJugador = lastIntent.getBooleanExtra("isJugador",false);

        DataBasePartidos dataBasePartidos = RepositoryFactory.getInstance();;

        if(isJugador){
            Jugador jugadorDetalle = dataBasePartidos.getJugador(persona);
            imagenJugador.setImageResource(jugadorDetalle.getImagen());
            nombreJugador.setText(jugadorDetalle.getNombre());
            dorsalJugador.setText(String.valueOf("#" + jugadorDetalle.getDorsal()));
            posicionJugador.setText(jugadorDetalle.getPosicion());
            edadJugador.setText(String.valueOf("Edad: " + jugadorDetalle.getEdad()));
        }else{
            Entrenador jugadorDetalle = dataBasePartidos.getEntrenador(persona);
            imagenJugador.setImageResource(jugadorDetalle.getImagen());
            nombreJugador.setText(jugadorDetalle.getNombre());
            dorsalJugador.setText("");
            posicionJugador.setText("");
            edadJugador.setText(String.valueOf("Edad: " + jugadorDetalle.getEdad()));
        }

    }
}
