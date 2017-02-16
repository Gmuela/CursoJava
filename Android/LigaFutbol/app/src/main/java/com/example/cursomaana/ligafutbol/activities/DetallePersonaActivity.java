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

    private ImageView imagenPersona;
    private TextView nombrePersona;
    private TextView dorsalPersona;
    private TextView posicionPersona;
    private TextView edadPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detalle_persona);

        imagenPersona = (ImageView) findViewById(R.id.imagen_persona_detalle);
        nombrePersona = (TextView) findViewById(R.id.nombre_persona_detalle);
        dorsalPersona = (TextView) findViewById(R.id.dorsal_persona_detalle);
        posicionPersona = (TextView) findViewById(R.id.posicion_persona_detalle);
        edadPersona = (TextView) findViewById(R.id.edad_persona_detalle);

        Intent lastIntent = getIntent();

        int persona = lastIntent.getIntExtra("persona", 0);
        boolean isJugador = lastIntent.getBooleanExtra("isJugador",false);

        DataBasePartidos dataBasePartidos = RepositoryFactory.getInstance();

        if(isJugador){
            Jugador jugadorDetalle = dataBasePartidos.getJugador(persona);
            imagenPersona.setImageResource(jugadorDetalle.getImagen());
            nombrePersona.setText(jugadorDetalle.getNombre());
            dorsalPersona.setText(String.valueOf("#" + jugadorDetalle.getDorsal()));
            posicionPersona.setText(jugadorDetalle.getPosicion());
            edadPersona.setText(String.valueOf("Edad: " + jugadorDetalle.getEdad()));
        }else{
            Entrenador jugadorDetalle = dataBasePartidos.getEntrenador(persona);
            imagenPersona.setImageResource(jugadorDetalle.getImagen());
            nombrePersona.setText(jugadorDetalle.getNombre());
            dorsalPersona.setText("");
            posicionPersona.setText("");
            edadPersona.setText(String.valueOf("Edad: " + jugadorDetalle.getEdad()));
        }

    }
}
