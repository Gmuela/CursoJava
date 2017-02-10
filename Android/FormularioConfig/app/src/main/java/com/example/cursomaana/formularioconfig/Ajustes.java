package com.example.cursomaana.formularioconfig;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.ToggleButton;

public class Ajustes extends AppCompatActivity {

    private Switch privateSwitch;
    private ToggleButton batteryToggle;
    private Button reset;
    private Button backButton;
    private Button okButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
        reset = (Button) findViewById(R.id.reset);
        backButton = (Button) findViewById(R.id.backButton);
        okButton = (Button) findViewById(R.id.okButton);
        privateSwitch = (Switch) findViewById(R.id.privateSwitch);
        batteryToggle = (ToggleButton) findViewById(R.id.batteryToggle);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                privateSwitch.setChecked(false);
                privateSwitch.setChecked(false);
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
                Intent goToNext = getIntent();

                String nombre = goToNext.getStringExtra("nombre");
                Intent nextIntent = new Intent(Ajustes.this, PantallaFinal.class);
                nextIntent.putExtra("nombreUsuario", nombre);
                nextIntent.putExtra("privateSwitch", privateSwitch.isChecked());
                nextIntent.putExtra("batteryToggle", batteryToggle.isChecked());
                startActivity(goToNext);
            }
        });
    }
}
