package com.example.cursomaana.formularioconfig;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.ToggleButton;

public class Ajustes extends AppCompatActivity {

    private Switch privateSwitch;
    private ToggleButton batteryToggle;
    private CheckBox wifiCheck;

    private RadioGroup redRadioGroup;

    private Spinner temas;
    private Spinner tonos;

    private Button backButton;
    private Button okButton;

    private FloatingActionButton reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        privateSwitch = (Switch) findViewById(R.id.aj_privateSwitch);
        batteryToggle = (ToggleButton) findViewById(R.id.aj_batteryToggle);

        reset = (FloatingActionButton) findViewById(R.id.aj_reset);
        backButton = (Button) findViewById(R.id.aj_backButton);
        okButton = (Button) findViewById(R.id.aj_okButton);

        wifiCheck = (CheckBox) findViewById(R.id.aj_wifi);
        redRadioGroup = (RadioGroup) findViewById(R.id.aj_redRadioGroup);

        temas = (Spinner) findViewById(R.id.aj_tema);
        tonos = (Spinner) findViewById(R.id.aj_tono);

        String[] array_temas = new String[]{"Oscuro","Claro","Naranja"};

        ArrayAdapter<String> adaptador_temas = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array_temas);
        adaptador_temas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adaptador_tonos =  ArrayAdapter.createFromResource(this, R.array.array_tonos,android.R.layout.simple_spinner_item);
        adaptador_tonos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        temas.setAdapter(adaptador_temas);
        tonos.setAdapter(adaptador_tonos);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                privateSwitch.setChecked(false);
                batteryToggle.setChecked(false);
                redRadioGroup.check(R.id.aj_G);
                wifiCheck.setChecked(false);
                tonos.setSelection(0);
                temas.setSelection(0);
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
                nextIntent.putExtra("wifi", wifiCheck.isChecked());
                String checkedRadioButon = getCheckedButton();
                nextIntent.putExtra("red", checkedRadioButon);
                nextIntent.putExtra("tema", String.valueOf(temas.getSelectedItem()));
                nextIntent.putExtra("tono", String.valueOf(tonos.getSelectedItem()));
                startActivity(nextIntent);
            }
        });
    }

    private String getCheckedButton() {

        int checkedRadioButtonId = redRadioGroup.getCheckedRadioButtonId();

        String returnChecked = "G";

        if(checkedRadioButtonId == R.id.aj_3G){
            returnChecked = "3G";
        } else if(checkedRadioButtonId == R.id.aj_4G){
            returnChecked = "4G";
        } else if(checkedRadioButtonId == R.id.aj_Automatico){
            returnChecked = "Automático";
        }

        return returnChecked;
    }
}
