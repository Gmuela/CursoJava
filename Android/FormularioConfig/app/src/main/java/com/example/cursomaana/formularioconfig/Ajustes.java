package com.example.cursomaana.formularioconfig;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.ToggleButton;

public class Ajustes extends AppCompatActivity {

    private Switch privateSwitch;
    private ToggleButton batteryToggle;
    private FloatingActionButton reset;
    private Button backButton;
    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        privateSwitch = (Switch) findViewById(R.id.aj_privateSwitch);
        batteryToggle = (ToggleButton) findViewById(R.id.aj_batteryToggle);

        reset = (FloatingActionButton) findViewById(R.id.aj_reset);
        backButton = (Button) findViewById(R.id.aj_backButton);
        okButton = (Button) findViewById(R.id.aj_okButton);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                privateSwitch.setChecked(false);
                batteryToggle.setChecked(false);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToForm = new Intent(Ajustes.this,FormularioDatos.class);
                startActivity(backToForm);
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lastIntent = getIntent();

                String nombre = lastIntent.getStringExtra("nombreUsuario");
                Intent nextIntent = new Intent(Ajustes.this, PaginaFinal.class);
                nextIntent.putExtra("nombreUsuario", nombre);
                nextIntent.putExtra("privateSwitch", privateSwitch.isChecked());
                nextIntent.putExtra("batteryToggle", batteryToggle.isChecked());
                startActivity(nextIntent);
            }
        });
    }
}
