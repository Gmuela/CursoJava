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
    private TextView wifi;
    private TextView red;
    private TextView tema;
    private TextView tono;

    private Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_final);

        nombre = (TextView) findViewById(R.id.f_nombre);
        battery = (TextView) findViewById(R.id.f_battery);
        wifi = (TextView) findViewById(R.id.f_wifi);
        red = (TextView) findViewById(R.id.f_red);
        tema = (TextView) findViewById(R.id.f_tema);
        tono = (TextView) findViewById(R.id.f_tono);

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

        boolean privateSwitch = lastIntent.getBooleanExtra("privateSwitch", false);
        boolean batteryToggle = lastIntent.getBooleanExtra("batteryToggle", false);
        boolean wifiCheck = lastIntent.getBooleanExtra("wifi", false);

        String nombreUsuario = lastIntent.getStringExtra("nombreUsuario");
        String redString = lastIntent.getStringExtra("red");
        String temaString = lastIntent.getStringExtra("tema");
        String tonoString = lastIntent.getStringExtra("tono");

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
        if(wifiCheck){
            wifi.setTextColor(Color.GREEN);
            wifi.setText("Activado");
        } else {
            wifi.setTextColor(Color.RED);
            wifi.setText("No activado");
        }

        nombre.setText(nombreUsuario);
        red.setText(redString);
        tema.setText(temaString);
        tono.setText(tonoString);

    }
}
