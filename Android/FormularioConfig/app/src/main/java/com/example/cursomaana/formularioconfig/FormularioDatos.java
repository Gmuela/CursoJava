package com.example.cursomaana.formularioconfig;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FormularioDatos extends AppCompatActivity {

    private EditText nombre;
    private TextInputLayout nameLayout;
    private EditText email;
    private TextInputLayout emailLayout;
    private EditText password;
    private TextInputLayout passwordLayout;

    private Button acceptButton;
    private Button cancelButton;

    private boolean errorName = true;
    private boolean errorEmail = true;
    private boolean errorPassword = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_datos);

        nombre = (EditText) findViewById(R.id.fd_nombre);
        nameLayout = (TextInputLayout) findViewById(R.id.fd_nombre_label);
        nameLayout.setErrorEnabled(true);

        nombre.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String comprobarNombre = String.valueOf(nombre.getText());
                if (comprobarNombre.isEmpty()) {
                    nameLayout.setError("El nombre es obligatorio");
                    errorName = true;
                    enableButton();
                } else {
                    nameLayout.setError(null);
                    errorName = false;
                    enableButton();
                }
            }
        });

        email = (EditText) findViewById(R.id.fd_email);
        emailLayout = (TextInputLayout) findViewById(R.id.fd_email_label);
        emailLayout.setErrorEnabled(true);


        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String comprobarEmail = String.valueOf(email.getText());
                Pattern p = Pattern.compile("^[A-Za-z].*?@gmail\\.com$");
                Matcher m = p.matcher(comprobarEmail);
                if (!m.find()) {
                    emailLayout.setError("Email no válido");
                    errorEmail = true;
                    enableButton();
                } else {
                    emailLayout.setError(null);
                    errorEmail = false;
                    enableButton();
                }
            }
        });

        password = (EditText) findViewById(R.id.fd_password);
        passwordLayout = (TextInputLayout) findViewById(R.id.fd_password_label);
        passwordLayout.setErrorEnabled(true);

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String comprobarPassword = String.valueOf(password.getText());
                if (comprobarPassword.length() < 4) {
                    passwordLayout.setError("Password demasiado corta (mínimo 4 caractéres)");
                    acceptButton.setEnabled(false);
                    errorPassword = true;
                    enableButton();
                } else {
                    passwordLayout.setError(null);
                    errorPassword = false;
                    enableButton();
                }
            }
        });

        acceptButton = (Button) findViewById(R.id.fd_acceptButton);
        cancelButton = (Button) findViewById(R.id.fd_cancelButton);



        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormularioDatos.this, Ajustes.class);
                intent.putExtra("nombreUsuario", String.valueOf(nombre.getText()));
                startActivity(intent);

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre = (EditText) findViewById(R.id.fd_nombre);
                email = (EditText) findViewById(R.id.fd_email);
                nombre.setText("");
                email.setText("");
            }
        });
    }

    private void enableButton() {
        if(!errorName && !errorEmail && !errorPassword){
            acceptButton.setEnabled(true);
        } else{
            acceptButton.setEnabled(false);
        }
    }
}
