package com.example.cursomaana.listprueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Titular[] titulares = new Titular[10];

        for (int i = 0; i < titulares.length; i++) {
            titulares[i] = new Titular("Titulo"+i,"Subtítulo"+i);
        }

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this, titulares);

        ListView lista = (ListView) findViewById(R.id.lista);

        lista.setAdapter(adaptador);

    }
}
