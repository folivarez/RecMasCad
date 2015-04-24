package com.example.fede.recmascad;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


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
        ArrayAdapter<CharSequence> ad_tatuajes_lugar;

        ArrayAdapter<CharSequence> ad_dentadura;
        ArrayAdapter<CharSequence> ad_discapacidad_zona;
        ArrayAdapter<CharSequence> ad_discapacidad_lugar;
        ArrayAdapter<CharSequence> ad_indumentaria_zona;
        ArrayAdapter<CharSequence> ad_indumentaria_color;



        //Obtener instancia del GameSpinner
        Spinner sp_sexo = (Spinner) findViewById(R.id.cb_sexo);
        Spinner sp_edad = (Spinner) findViewById(R.id.cb_edad);
        Spinner sp_piel = (Spinner) findViewById(R.id.cb_piel);
        Spinner sp_raza = (Spinner) findViewById(R.id.cb_raza);

        Spinner sp_pelo_tipo = (Spinner) findViewById(R.id.cb_pelo_tipo);
        Spinner sp_pelo_color = (Spinner) findViewById(R.id.cb_pelo_color);
        Spinner sp_ojos = (Spinner) findViewById(R.id.cb_ojos);
        Spinner sp_altura = (Spinner) findViewById(R.id.cb_altura);

        Spinner sp_cicatrices_zona = (Spinner) findViewById(R.id.cb_cicatrices_zona);
        Spinner sp_cicatrices_lugar = (Spinner) findViewById(R.id.cb_cicatrices_lugar);
        Spinner sp_tatuajes_zona = (Spinner) findViewById(R.id.cb_tatuajes_zona);
        Spinner sp_tatuajes_lugar = (Spinner) findViewById(R.id.cb_tatuajes_lugar);

        Spinner sp_dentadura = (Spinner) findViewById(R.id.cb_dentadura);
        Spinner sp_discapacidad_zona = (Spinner) findViewById(R.id.cb_discapacidad_zona);
        Spinner sp_discapacidad_lugar = (Spinner) findViewById(R.id.cb_discapacidad_lugar);
        Spinner sp_idumentaria_zona = (Spinner) findViewById(R.id.cb_indumentaria_zona);
        Spinner sp_indumentaria_color = (Spinner) findViewById(R.id.cb_indumentaria_color);



        //Asignas el origen de datos desde los recursos
        ad_sexo = ArrayAdapter.createFromResource(this, R.array.a_sexo, android.R.layout.simple_spinner_item);
        ad_edad = ArrayAdapter.createFromResource(this, R.array.a_edad, android.R.layout.simple_spinner_item);
        ad_piel = ArrayAdapter.createFromResource(this, R.array.a_piel, android.R.layout.simple_spinner_item);
        ad_raza = ArrayAdapter.createFromResource(this, R.array.a_raza, android.R.layout.simple_spinner_item);

        ad_pelo_tipo = ArrayAdapter.createFromResource(this, R.array.a_pelo_tipo, android.R.layout.simple_spinner_item);
        ad_pelo_color = ArrayAdapter.createFromResource(this, R.array.a_pelo_color, android.R.layout.simple_spinner_item);
        ad_ojos = ArrayAdapter.createFromResource(this, R.array.a_ojos, android.R.layout.simple_spinner_item);
        ad_altura = ArrayAdapter.createFromResource(this, R.array.a_altura, android.R.layout.simple_spinner_item);

        ad_cicatrices_zona = ArrayAdapter.createFromResource(this, R.array.a_cicatrices_zona, android.R.layout.simple_spinner_item);
        ad_cicatrices_lugar = ArrayAdapter.createFromResource(this, R.array.a_cicatrices_lugar, android.R.layout.simple_spinner_item);
        ad_tatuajes_zona = ArrayAdapter.createFromResource(this, R.array.a_tatuajes_zona, android.R.layout.simple_spinner_item);
        ad_tatuajes_lugar = ArrayAdapter.createFromResource(this, R.array.a_tatuajes_lugar, android.R.layout.simple_spinner_item);

        ad_dentadura = ArrayAdapter.createFromResource(this, R.array.a_dentadura, android.R.layout.simple_spinner_item);
        ad_discapacidad_zona = ArrayAdapter.createFromResource(this, R.array.a_discapacidad_zona, android.R.layout.simple_spinner_item);
        ad_discapacidad_lugar = ArrayAdapter.createFromResource(this, R.array.a_discapacidad_lugar, android.R.layout.simple_spinner_item);
        ad_indumentaria_zona = ArrayAdapter.createFromResource(this, R.array.a_indumentaria_zona, android.R.layout.simple_spinner_item);
        ad_indumentaria_color = ArrayAdapter.createFromResource(this, R.array.a_indumentaria_color, android.R.layout.simple_spinner_item);

        //Asignas el layout a inflar para cada elemento
        //al momento de desplegar la lista
        ad_sexo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad_edad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad_piel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad_raza.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ad_pelo_tipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad_pelo_color.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad_ojos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad_altura.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ad_cicatrices_zona.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad_cicatrices_lugar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad_tatuajes_zona.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad_tatuajes_lugar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ad_dentadura.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad_discapacidad_zona.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad_discapacidad_lugar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad_indumentaria_zona.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad_indumentaria_color.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Seteas el adaptador
        sp_sexo.setAdapter(ad_sexo);
        sp_edad.setAdapter(ad_edad);
        sp_piel.setAdapter(ad_piel);
        sp_raza.setAdapter(ad_raza);

        sp_pelo_tipo.setAdapter(ad_pelo_tipo);
        sp_pelo_color.setAdapter(ad_pelo_color);
        sp_ojos.setAdapter(ad_ojos);
        sp_altura.setAdapter(ad_altura);

        sp_cicatrices_zona.setAdapter(ad_cicatrices_zona);
        sp_cicatrices_lugar.setAdapter(ad_cicatrices_lugar);
        sp_tatuajes_zona.setAdapter(ad_tatuajes_zona);
        sp_tatuajes_lugar.setAdapter(ad_tatuajes_lugar);

        sp_dentadura.setAdapter(ad_dentadura);
        sp_discapacidad_zona.setAdapter(ad_discapacidad_zona);
        sp_discapacidad_lugar.setAdapter(ad_discapacidad_lugar);
        sp_idumentaria_zona.setAdapter(ad_indumentaria_zona);
        sp_indumentaria_color.setAdapter(ad_indumentaria_color);

        sp_altura.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(parent.getContext(),"Selecciono " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
