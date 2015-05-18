package com.example.fede.recmascad;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;


public class DatosDeLaVictima_activity extends ActionBarActivity {

    public String s_altura;
    public String s_edad;
    public String s_sexo;
    public String s_piel;
    public String s_raza;

    public String s_peloTipo;
    public String s_peloColor;
    public String s_ojos;

    public String s_cicatricesZona;
    public String s_cicatricesLugar;
    public String s_tatuajesZona;
    public String s_tatuajesLugar;

    public String s_dentadura;
    public String s_discapacidadZona;
    public String s_discapacidadLugar;
    public String s_indumentariaZona;
    public String s_indumentariaColor;

    Button btnCamara;
    private String foto;
    private static int TAKE_PICTURE = 1;
    double aleatorio = 0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_de_la_victima);

        //ArrayAdapter para conectar el Spinner a nuestros recursos strings.xml
        final ArrayAdapter<CharSequence> ad_sexo;
        final ArrayAdapter<CharSequence> ad_edad;
        final ArrayAdapter<CharSequence> ad_piel;
        final ArrayAdapter<CharSequence> ad_raza;

        final ArrayAdapter<CharSequence> ad_pelo_tipo;
        final ArrayAdapter<CharSequence> ad_pelo_color;
        final ArrayAdapter<CharSequence> ad_ojos;
        final ArrayAdapter<CharSequence> ad_altura;

        final ArrayAdapter<CharSequence> ad_cicatrices_zona;
        final ArrayAdapter<CharSequence> ad_cicatrices_lugar;
        final ArrayAdapter<CharSequence> ad_tatuajes_zona;
        final ArrayAdapter<CharSequence> ad_tatuajes_lugar;

        final ArrayAdapter<CharSequence> ad_dentadura;
        final ArrayAdapter<CharSequence> ad_discapacidad_zona;
        final ArrayAdapter<CharSequence> ad_discapacidad_lugar;
        final ArrayAdapter<CharSequence> ad_indumentaria_zona;
        final ArrayAdapter<CharSequence> ad_indumentaria_color;



        //Obtener instancia del GameSpinner
        final Spinner sp_sexo = (Spinner) findViewById(R.id.cb_sexo);
        final Spinner sp_edad = (Spinner) findViewById(R.id.cb_edad);
        final Spinner sp_piel = (Spinner) findViewById(R.id.cb_piel);
        final Spinner sp_raza = (Spinner) findViewById(R.id.cb_raza);

        final Spinner sp_pelo_tipo = (Spinner) findViewById(R.id.cb_pelo_tipo);
        final Spinner sp_pelo_color = (Spinner) findViewById(R.id.cb_pelo_color);
        final Spinner sp_ojos = (Spinner) findViewById(R.id.cb_ojos);
        final Spinner sp_altura = (Spinner) findViewById(R.id.cb_altura);

        final Spinner sp_cicatrices_zona = (Spinner) findViewById(R.id.cb_cicatrices_zona);
        final Spinner sp_cicatrices_lugar = (Spinner) findViewById(R.id.cb_cicatrices_lugar);
        final Spinner sp_tatuajes_zona = (Spinner) findViewById(R.id.cb_tatuajes_zona);
        final Spinner sp_tatuajes_lugar = (Spinner) findViewById(R.id.cb_tatuajes_lugar);

        final Spinner sp_dentadura = (Spinner) findViewById(R.id.cb_dentadura);
        final Spinner sp_discapacidad_zona = (Spinner) findViewById(R.id.cb_discapacidad_zona);
        final Spinner sp_discapacidad_lugar = (Spinner) findViewById(R.id.cb_discapacidad_lugar);
        final Spinner sp_indumentaria_zona = (Spinner) findViewById(R.id.cb_indumentaria_zona);
        final Spinner sp_indumentaria_color = (Spinner) findViewById(R.id.cb_indumentaria_color);



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
        sp_indumentaria_zona.setAdapter(ad_indumentaria_zona);
        sp_indumentaria_color.setAdapter(ad_indumentaria_color);

        sp_edad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s_edad = sp_edad.getItemAtPosition(position).toString();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp_sexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s_sexo = sp_sexo.getItemAtPosition(position).toString();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp_altura.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 s_altura = sp_altura.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp_raza.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s_raza = sp_raza.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp_piel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s_piel = sp_piel.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp_ojos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s_ojos = sp_ojos.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp_cicatrices_zona.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s_cicatricesZona = sp_cicatrices_zona.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp_cicatrices_lugar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s_cicatricesLugar = sp_cicatrices_lugar.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp_tatuajes_zona.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s_tatuajesZona = sp_tatuajes_zona.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp_tatuajes_lugar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s_tatuajesLugar = sp_tatuajes_lugar.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp_indumentaria_color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s_indumentariaColor = sp_indumentaria_color.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp_indumentaria_zona.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s_indumentariaZona = sp_indumentaria_zona.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp_dentadura.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s_dentadura = sp_dentadura.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp_discapacidad_lugar.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s_discapacidadLugar = sp_discapacidad_lugar.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp_discapacidad_zona.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s_discapacidadZona = sp_discapacidad_zona.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp_pelo_tipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s_peloTipo = sp_pelo_tipo.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        sp_pelo_color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                s_peloColor = sp_pelo_color.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        //Declaramos las variables de los botones
        final Button btn_siguiente = (Button)findViewById(R.id.btn_siguiente_enviar);

        //Listener para el boton de siguiente
        btn_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ArrayList<String> aDatosVictima =  new ArrayList<String>();
                aDatosVictima.add(s_altura);            //0
                aDatosVictima.add(s_edad);              //1
                aDatosVictima.add(s_sexo);              //2
                aDatosVictima.add(s_piel);                  //3
                aDatosVictima.add(s_raza);              //4
                aDatosVictima.add(s_peloTipo);              //5
                aDatosVictima.add(s_peloColor);             //6
                aDatosVictima.add(s_ojos);                  //7
                aDatosVictima.add(s_cicatricesZona);            //8
                aDatosVictima.add(s_cicatricesLugar);           //9
                aDatosVictima.add(s_tatuajesZona);              //10
                aDatosVictima.add(s_tatuajesLugar);             //11
                aDatosVictima.add(s_dentadura);                 //12
                aDatosVictima.add(s_discapacidadZona);              //13
                aDatosVictima.add(s_discapacidadLugar);             //14
                aDatosVictima.add(s_indumentariaZona);              //15
                aDatosVictima.add(s_indumentariaColor);             //16
                aDatosVictima.add(foto);             //16



                //Creamos el Intent
                Intent inte = new Intent(DatosDeLaVictima_activity.this, DatosAEnviar_activity.class);

                //Creamos la información a pasar entre actividades
                /*Bundle b = new Bundle();
                b.putString("datosVictima ", json);*/

                //Añadimos la información al intent
                inte.putExtra("aVictima", aDatosVictima);

                //Iniciamos la nueva actividad
                startActivity(inte);

            }
        });

        //Sacar Foto
        aleatorio = new Double(Math.random() * 100).intValue();
        foto = Environment.getExternalStorageDirectory() + "/imagen"+ aleatorio +".jpg";

        btnCamara = (Button) findViewById(R.id.btn_tomar_foto);
        btnCamara.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Uri output = Uri.fromFile(new File(foto));
                intent.putExtra(MediaStore.EXTRA_OUTPUT, output);
                //startActivityForResult(intent, TAKE_PICTURE); // 1 para la camara, 2 para la galeria
                startActivityForResult(intent, TAKE_PICTURE); // 1 para la camara, 2 para la galeria
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

