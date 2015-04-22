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


        //Obtener instancia del GameSpinner
        Spinner sp_sexo = (Spinner) findViewById(R.id.cb_sexo);
        Spinner sp_edad = (Spinner) findViewById(R.id.cb_edad);

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
