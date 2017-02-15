package com.example.cursomaana.ligafutbol.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.cursomaana.ligafutbol.R;
import com.example.cursomaana.ligafutbol.beans.Equipo;
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




    }
}