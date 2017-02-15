package com.example.cursomaana.ligafutbol.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.cursomaana.ligafutbol.R;
import com.example.cursomaana.ligafutbol.adapters.AdaptadorPartidos;
import com.example.cursomaana.ligafutbol.beans.Partido;
import com.example.cursomaana.ligafutbol.repositories.DataBasePartidos;
import com.example.cursomaana.ligafutbol.repositories.RepositoryFactory;

public class ListaPartidosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO Pantalla completa
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lista_partidos);

        DataBasePartidos dataBasePartidos = RepositoryFactory.getInstance();;

        final AdaptadorPartidos adaptador = new AdaptadorPartidos(this, dataBasePartidos.getPartidos());

        ListView lista = (ListView) findViewById(R.id.lista_partidos);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Partido partidoClickado = (Partido)parent.getItemAtPosition(position);
                Intent nextIntent = new Intent(ListaPartidosActivity.this, DetallePartidoActivity.class);
                nextIntent.putExtra("partido", partidoClickado.getId());
                startActivity(nextIntent);
            }
        });
    }
}
