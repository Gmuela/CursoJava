package com.example.cursomaana.ligafutbol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBasePartidos dataBasePartidos = new DataBasePartidos();

        final AdaptadorPartidos adaptador = new AdaptadorPartidos(this, dataBasePartidos.getPartidos());

        ListView lista = (ListView) findViewById(R.id.lista_partidos);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Partido partidoClickado = adaptador.getItem(position);
                Intent nextIntent = new Intent(MainActivity.this, DetallePartido.class);
                nextIntent.putExtra("idPartido", partidoClickado.getId());
                startActivity(nextIntent);
            }
        });
    }
}
