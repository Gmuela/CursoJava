package cursomaana.example.com.androidexamen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormularioActivity extends AppCompatActivity {


    private EditText nombre;
    private TextInputLayout nameLayout;
    private EditText email;
    private TextInputLayout emailLayout;
    private EditText password;
    private TextInputLayout passwordLayout;
    private EditText verifPass;
    private TextInputLayout verifPassLayout;
    private RadioGroup sexo;
    private CheckBox aficionCine;
    private CheckBox aficionMusica;
    private CheckBox aficionDeporte;
    private CheckBox aficionManualidades;
    private Spinner nacionalidad;

    private Button acceptButton;

    private boolean errorName = true;
    private boolean errorEmail = true;
    private boolean errorPassword = true;
    private boolean errorVerifPassword = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        nombre = (EditText) findViewById(R.id.f_nombre);
        nameLayout = (TextInputLayout) findViewById(R.id.f_nombre_label);
        nameLayout.setErrorEnabled(true);

        email = (EditText) findViewById(R.id.f_email);
        emailLayout = (TextInputLayout) findViewById(R.id.f_email_label);
        emailLayout.setErrorEnabled(true);

        password = (EditText) findViewById(R.id.f_password);
        passwordLayout = (TextInputLayout) findViewById(R.id.f_password_label);
        passwordLayout.setErrorEnabled(true);

        verifPass = (EditText) findViewById(R.id.f_verif_pass);
        verifPassLayout = (TextInputLayout) findViewById(R.id.f_verif_pass_label);
        verifPassLayout.setErrorEnabled(true);

        sexo = (RadioGroup) findViewById(R.id.f_rad_sexo);

        aficionCine = (CheckBox) findViewById(R.id.af_cine);
        aficionMusica = (CheckBox) findViewById(R.id.af_musica);
        aficionDeporte = (CheckBox) findViewById(R.id.af_deporte);
        aficionManualidades = (CheckBox) findViewById(R.id.af_manualidades);

        Pais espania = new Pais(R.drawable.espania, "España");
        Pais uk = new Pais(R.drawable.uk, "Inglaterra");
        Pais francia = new Pais(R.drawable.francia, "Francia");
        Pais alemania = new Pais(R.drawable.alemania, "Alemania");

        Pais[] paises = {espania, uk, francia, alemania};

        nacionalidad = (Spinner) findViewById(R.id.spinner_nacionalidad);

        AdaptadorSpinnerNacionalidad spinnerNacionalidad = new AdaptadorSpinnerNacionalidad(this, paises);

        spinnerNacionalidad.setDropDownViewResource(R.layout.spinner_view);

        nacionalidad.setAdapter(spinnerNacionalidad);

        acceptButton = (Button) findViewById(R.id.f_acceptButton);


        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String comprobarNombre = String.valueOf(nombre.getText());
                if (comprobarNombre.isEmpty()) {
                    nameLayout.setError("El nombre es obligatorio");
                    errorName = true;
                } else {
                    nameLayout.setError(null);
                    errorName = false;
                }

                String comprobarPassword = String.valueOf(password.getText());
                String comprobarPasswordsIguales = String.valueOf(verifPass.getText());
                if (!comprobarPassword.equals(comprobarPasswordsIguales)) {
                    verifPassLayout.setError("Las passwords no coinciden");
                    errorVerifPassword = true;
                } else {
                    verifPassLayout.setError(null);
                    errorVerifPassword = false;
                }

                if (comprobarPassword.length() < 6) {
                    passwordLayout.setError("Password demasiado corta (mínimo 6 caractéres)");
                    errorPassword = true;
                } else {
                    passwordLayout.setError(null);
                    errorPassword = false;
                }

                String comprobarEmail = String.valueOf(email.getText());
                Pattern p = Pattern.compile("^[A-Za-z].*?@gmail\\.com$");
                Matcher m = p.matcher(comprobarEmail);

                if (!m.find()) {
                    emailLayout.setError("Email no válido. Formato xxx@yyy.zzz");
                    errorEmail = true;
                } else {
                    emailLayout.setError(null);
                    errorEmail = false;
                }

                if (!errorName && !errorEmail && !errorPassword && !errorVerifPassword) {
                    Intent intent = new Intent(FormularioActivity.this, PantallaFinalActivity.class);
                    intent.putExtra("nombre", String.valueOf(nombre.getText()));
                    intent.putExtra("email", String.valueOf(email.getText()));
                    Pais pais = (Pais) nacionalidad.getSelectedItem();
                    intent.putExtra("nacionalidad", pais.getNombre());
                    intent.putExtra("sexo", getCheckedButton());
                    String[] aficiones = new String[4];
                    aficiones[0]="";
                    aficiones[1]="";
                    aficiones[2]="";
                    aficiones[3]="";
                    if(aficionCine.isChecked()){
                        aficiones[0]=("Cine");
                    }
                    if(aficionMusica.isChecked()){
                        aficiones[1]=("Música");
                    }
                    if(aficionDeporte.isChecked()){
                        aficiones[2]=("Deporte");
                    }
                    if(aficionManualidades.isChecked()){
                        aficiones[3]=("Manualidades");
                    }
                    intent.putExtra("aficiones",aficiones);
                    intent.putExtra("password",String.valueOf(password.getText()));
                    startActivity(intent);
                }
            }
        });
    }

    private String getCheckedButton() {

        int checkedRadioButtonId = sexo.getCheckedRadioButtonId();

        String returnChecked = "default";

        if(checkedRadioButtonId == R.id.rad_hombre){
            returnChecked = "Hombre";
        } else if(checkedRadioButtonId == R.id.rad_mujer){
            returnChecked = "Mujer";
        }

        return returnChecked;
    }
}
