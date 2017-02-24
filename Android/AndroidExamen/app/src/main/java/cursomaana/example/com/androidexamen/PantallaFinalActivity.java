package cursomaana.example.com.androidexamen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PantallaFinalActivity extends AppCompatActivity {

    private TextView nombre;
    private TextView email;
    private TextView nacionalidad;
    private TextView sexo;
    private TextView aficiones;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_final);

        nombre = (TextView) findViewById(R.id.nombre_final);
        email = (TextView) findViewById(R.id.email_final);
        nacionalidad = (TextView) findViewById(R.id.nacionalidad_final);
        sexo = (TextView) findViewById(R.id.sexo_final);
        aficiones = (TextView) findViewById(R.id.aficiones_final);
        password = (TextView) findViewById(R.id.password_final);

        Intent lastIntent = getIntent();

        String nombreString = lastIntent.getStringExtra("nombre");
        String emailString = lastIntent.getStringExtra("email");
        String nacionalidadString = lastIntent.getStringExtra("nacionalidad");
        String sexoString = lastIntent.getStringExtra("sexo");
        String[] aficionesArray = lastIntent.getStringArrayExtra("aficiones");
        String passwordString = lastIntent.getStringExtra("password");

        String aficionesString="";

        nombre.setText(nombreString);
        email.setText(emailString);
        nacionalidad.setText(nacionalidadString);
        sexo.setText(sexoString);
        for (String aficion : aficionesArray) {
            if(!aficion.equals("")){
                aficionesString += aficion+",";
            }
        }
        aficiones.setText(aficionesString);
        password.setText(passwordString);

    }
}
