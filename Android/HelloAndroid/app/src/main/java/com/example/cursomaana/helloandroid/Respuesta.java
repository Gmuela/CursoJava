package com.example.cursomaana.helloandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Respuesta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuesta);
        String nombreUsuario = getIntent().getStringExtra("nombreUsuario");
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Hola " + nombreUsuario);
    }
}
