package com.example.cursomaana.formularioconfig;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormularioDatos extends AppCompatActivity {

    private EditText nombre;
    private EditText email;
    private Button acceptButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_datos);

        nombre = (EditText) findViewById(R.id.name);

        acceptButton = (Button) findViewById(R.id.acceptButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormularioDatos.this, Ajustes.class);
                intent.putExtra("nombreUsuario", nombre.getText());
                startActivity(intent);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = (EditText) findViewById(R.id.name);
                email = (EditText) findViewById(R.id.email);
                nombre.setText("");
                email.setText("");
            }
        });
    }
}
