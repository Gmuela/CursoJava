package com.example.cursomaana.formularioconfig;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PaginaFinal extends AppCompatActivity {

    private TextView nombre;
    private TextView privacidad;
    private TextView battery;
    private Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_final);
        nombre = (TextView) findViewById(R.id.f_nombre);
        battery = (TextView) findViewById(R.id.f_battery);
        privacidad = (TextView) findViewById(R.id.f_privacidad);
        volver = (Button) findViewById(R.id.f_volver);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volver = new Intent(PaginaFinal.this, FormularioDatos.class);
                startActivity(volver);
            }
        });

        Intent lastIntent = getIntent();

        String nombreUsuario = lastIntent.getStringExtra("nombreUsuario");
        boolean privateSwitch = lastIntent.getBooleanExtra("privateSwitch", false);
        boolean batteryToggle = lastIntent.getBooleanExtra("batteryToggle", false);

        nombre.setText(nombreUsuario);

        if(batteryToggle){
            battery.setTextColor(Color.GREEN);
            battery.setText("Activado");
        } else {
            battery.setTextColor(Color.RED);
            battery.setText("No activado");
        }

        if(privateSwitch){
            privacidad.setTextColor(Color.GREEN);
            privacidad.setText("Activado");
        } else {
            privacidad.setTextColor(Color.RED);
            privacidad.setText("No activado");
        }
    }
}
