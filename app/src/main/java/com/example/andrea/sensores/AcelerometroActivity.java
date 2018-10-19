package com.example.andrea.sensores;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.List;

public class AcelerometroActivity extends AppCompatActivity  implements SensorEventListener{
    TextView x,y,z;
    Sensor acelerometro;
    //Se define el manejador de los sensores
    SensorManager sm;
    //Se define una lista de tipo sensor para realizar las consultas
    List<Sensor> sensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);
        x=(TextView) findViewById(R.id.x);
        y=(TextView) findViewById(R.id.y);
        z=(TextView) findViewById(R.id.z);
        //Se indica al manejador de sensores que se active el servicio
        sm=(SensorManager) getSystemService(SENSOR_SERVICE);
        //Se indica a sensors que el sensor a usar es el de tipo Acelerómetro
        sensors=sm.getSensorList(Sensor.TYPE_ACCELEROMETER); //acelerometro
        //En este punto se verifica con el tamaño de sensors si existe el sensor de
        // acelerómetro.
        //Si el tamaño es mayor que 0, entonces si contamos con el sensor, de lo contrario,
        // no se puede desarrollar el ejercicio.
        if(sensors.size()>0){
            //Con esta instrucción se activa la función de "escuchar" los sensores, con lo
            //que podemos saber si existe o no un cambio de valor en los mismos.
            //El primer argumento activa la función. El segundo argumento manda a que tome
            //el valor inicial 0. El tercer argumento indica la velocidad para manejar los
            //valores.
            sm.registerListener((SensorEventListener) this,sensors.get(0),
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    //Método que se manda llamar cada vez que el sensor cambie su valor.
    @Override
    public void onSensorChanged(SensorEvent event){
        //La variable event es un arreglo que contiene los valores del
        //acelerómetro en los 3 ejes
        x.setText("Eje x: "+event.values[0]);
        y.setText("Eje y: "+event.values[1]);
        z.setText("Eje z: "+event.values[2]);
    }
    //Método que se manda llamar cada vez que el sensor cambie su precisión.
@Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){
    }
}
