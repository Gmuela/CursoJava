package ejemplogoogleapi.cursomaana.example.com.ejemplohardware;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView ejeX;
    private TextView ejeY;
    private TextView ejeZ;
    private TextView dirX;
    private TextView dirY;
    private TextView dirZ;
    private TextToSpeech textToSpeech;
    private EditText textSpeech;
    private Button speech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ejeX = (TextView) findViewById(R.id.eje_x);
        ejeY = (TextView) findViewById(R.id.eje_y);
        ejeZ = (TextView) findViewById(R.id.eje_z);
        dirX = (TextView) findViewById(R.id.dir_x);
        dirY = (TextView) findViewById(R.id.dir_y);
        dirZ = (TextView) findViewById(R.id.dir_z);

        speech = (Button) findViewById(R.id.button_speech);
        textSpeech = (EditText) findViewById(R.id.text_speech);

        speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.speak(String.valueOf(textSpeech.getText()), TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });

        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    textToSpeech.setLanguage(Locale.getDefault());
                }
            }
        });

        final SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if(event.sensor.getType() == Sensor.TYPE_GYROSCOPE){
                    float axiX = event.values[0];
                    float axiY = event.values[1];
                    float axiZ = event.values[2];

                    ejeX.setText("Eje X = " + Float.toString(axiX));
                    ejeY.setText("Eje Y = " + Float.toString(axiY));
                    ejeZ.setText("Eje Z = " + Float.toString(axiZ));
                    if(axiX < 0){
                        dirX.setText("Movimiento a la derecha");
                    } else{
                        dirX.setText("Movimiento a la izquierda");
                    }
                    if(axiY < 0){
                        dirY.setText("Movimiento hacia arriba");
                    } else{
                        dirY.setText("Movimiento hacia abajo");
                    }
                    if(axiZ < 0){
                        dirZ.setText("Movimiento hacia delante");
                    } else{
                        dirZ.setText("Movimiento hacia atrás");
                    }
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE),SensorManager.SENSOR_DELAY_NORMAL);
    }
}
