package com.example.fede.recmascad;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class DatosDeLaVictima_activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_de_la_victima);

        //ArrayAdapter para conectar el Spinner a nuestros recursos strings.xml
        ArrayAdapter<CharSequence> ad_sexo;
        ArrayAdapter<CharSequence> ad_edad;
        ArrayAdapter<CharSequence> ad_piel;
        ArrayAdapter<CharSequence> ad_raza;
        ArrayAdapter<CharSequence> ad_pelo_tipo;
        ArrayAdapter<CharSequence> ad_pelo_color;
        ArrayAdapter<CharSequence> ad_ojos;
        ArrayAdapter<CharSequence> ad_altura;
        ArrayAdapter<CharSequence> ad_cicatrices_zona;
        ArrayAdapter<CharSequence> ad_cicatrices_lugar;
        ArrayAdapter<CharSequence> ad_tatuajes_zona;
        ArrayAdapter<CharSequence> ad_dentadura;
        ArrayAdapter<CharSequence> ad_discapacidad_zona;
        ArrayAdapter<CharSequence> ad_discapacidad_lugar;
        ArrayAdapter<CharSequence> ad_indumentaria_superior;
        ArrayAdapter<CharSequence> ad_indumentaria_inferior;



        //Obtener instancia del GameSpinner
        Spinner sp_sexo = (Spinner) findViewById(R.id.cb_sexo);
        Spinner sp_edad = (Spinner) findViewById(R.id.cb_edad);
        Spinner sp_piel = (Spinner) findViewById(R.id.cb_piel);
        Spinner sp_raza = (Spinner) findViewById(R.id.cb_raza);
        Spinner sp_pelo_tipo = (Spinner) findViewById(R.id.cb_pelo_tipo);
        Spinner sp_pelo_color = (Spinner) findViewById(R.id.cb_pelo_color);
        Spinner sp_ojos = (Spinner) findViewById(R.id.cb_ojos);
        Spinner sp_altura = (Spinner) findViewById(R.id.cb_altura);


        //Asignas el origen de datos desde los recursos
        ad_sexo = ArrayAdapter.createFromResource(this, R.array.a_sexo, android.R.layout.simple_spinner_item);
        ad_edad = ArrayAdapter.createFromResource(this, R.array.a_edad, android.R.layout.simple_spinner_item);

        //Asignas el layout a inflar para cada elemento
        //al momento de desplegar la lista
        ad_sexo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad_edad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Seteas el adaptador
        sp_sexo.setAdapter(ad_sexo);
        sp_edad.setAdapter(ad_edad);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
