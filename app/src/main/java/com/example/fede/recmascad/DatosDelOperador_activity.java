package com.example.fede.recmascad;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;

public class DatosDelOperador_activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_del_operador);

        //Declaramos las variables de los botones
        final Button btn_siguiente = (Button)findViewById(R.id.btn_siguiente);


        //Listener para el boton de Jugar
        btn_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Creamos el Intent
                Intent inte = new Intent(DatosDelOperador_activity.this, DatosDeLaVictima_activity.class);

              /*  //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("NOMBRE", texto_usuario.getText().toString());

                //Añadimos la información al intent
                intent.putExtras(b);*/

                //Iniciamos la nueva actividad
                startActivity(inte);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_datos_del_operador, menu);
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
