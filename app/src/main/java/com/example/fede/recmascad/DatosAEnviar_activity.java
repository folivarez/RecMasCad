package com.example.fede.recmascad;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


import org.json.JSONException;
import org.json.JSONObject;


public class DatosAEnviar_activity extends ActionBarActivity {

    EditText textOut;
    TextView textIn;
    ArrayList<String> aVictima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy); //Soluciono error policy

        setContentView(R.layout.datos_a_enviar);


        aVictima = getIntent().getStringArrayListExtra("aVictima");

        textOut = (EditText)findViewById(R.id.textout);
        Button buttonSend = (Button)findViewById(R.id.send);
        textIn = (TextView)findViewById(R.id.textin);
        buttonSend.setOnClickListener(buttonSendOnClickListener);
    }

    public void sendVictima(Victima newVictima) {
        //Obtenemos los datos del Articles en foramto JSON
        String strJson = newVictima.toJSON();

        //Se define la URL del servidor a la cual se enviarán lso datos
        String baseUrl = "http://104.236.125.167/index.php";

        //Se ejecuta la peticion Http POST empleando AsyncTAsk
        new MyHttpPostRequest().execute(baseUrl, strJson);
    }

    public void processResult(String result) {
        if (result.contains("OK")) {
            Toast.makeText(getApplicationContext(), getString(R.string.msg_success), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), getString(R.string.msg_error) + result, Toast.LENGTH_LONG).show();
        }
    }

    Button.OnClickListener buttonSendOnClickListener  = new Button.OnClickListener(){

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub

            processScreen();
        }};

    private void processScreen(){
        //Obtenemos los datos insertados por el usuario en pantalla
        String s_altura = aVictima.get(0);
        String s_edad = aVictima.get(1);
        String s_sexo = aVictima.get(2);
        String s_piel = aVictima.get(3);
        String s_raza = aVictima.get(4);
        String s_peloTipo = aVictima.get(5);
        String s_peloColor = aVictima.get(6);
        String s_ojos = aVictima.get(7);
        String s_cicatricesZona = aVictima.get(8);
        String s_cicatricesLugar = aVictima.get(9);
        String s_tatuajesZona = aVictima.get(10);
        String s_tatuajesLugar = aVictima.get(11);
        String s_dentadura = aVictima.get(12);
        String s_discapacidadZona = aVictima.get(13);
        String s_discapacidadLugar = aVictima.get(14);
        String s_indumentariaZona = aVictima.get(15);
        String s_indumentariaColor = aVictima.get(16);
        String s_imagen = null;
        try {
            s_imagen = convertirImangen(aVictima.get(17));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        Toast.makeText(getApplicationContext(), s_imagen , Toast.LENGTH_LONG).show();

        //Instanciamos el objeto Articles con los datos insertados por el usuario
        Victima newVictima = new Victima(s_altura,s_edad,s_sexo,s_piel,s_raza,s_peloTipo,s_peloColor,s_ojos,s_cicatricesZona,s_cicatricesLugar,s_tatuajesZona
                ,s_tatuajesLugar,s_dentadura,s_discapacidadZona,s_discapacidadLugar,s_indumentariaZona,s_indumentariaColor, s_imagen);

        //Llamamos la método sendNewArticle definido en el MainActivity
        //para Enviar los datos al servidor
        sendVictima(newVictima);
    }

    /*private String convertirImangen(String path) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(path);//You can get an inputStream using any IO API
        byte[] bytes;
        byte[] buffer = new byte[8192];
        int bytesRead;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        bytes = output.toByteArray();
        String encodedString = Base64.encodeToString(bytes, Base64.DEFAULT);
        return encodedString;
    }*/
    private String convertirImangen(String path) throws FileNotFoundException {
        File image = new File(path);
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(),bmOptions);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String temp = Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }

    /**
     * MyHttpPostRequest => Esta clase privada maneja toda la gestión de envío de datos al servidor
     *
     */
    private class MyHttpPostRequest extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... params) {
            BufferedReader in = null;
            String baseUrl = params[0];
            String jsonData = params[1];

            try {
                //Creamos un objeto Cliente HTTP para manejar la peticion al servidor
                HttpClient httpClient = new DefaultHttpClient();
                //Creamos objeto para armar peticion de tipo HTTP POST
                HttpPost post = new HttpPost(baseUrl);

                //Configuramos los parametos que vaos a enviar con la peticion HTTP POST
                List<NameValuePair> nvp = new ArrayList<NameValuePair>(2);
                nvp.add(new BasicNameValuePair("victima", jsonData));
                //post.setHeader("Content-type", "application/json");
                post.setEntity(new UrlEncodedFormEntity(nvp));

                //Se ejecuta el envio de la peticion y se espera la respuesta de la misma.
                HttpResponse response = httpClient.execute(post);
                //fedeLog.w(APP_TAG, response.getStatusLine().toString());

                //Obtengo el contenido de la respuesta en formato InputStream Buffer y la paso a formato String
                in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                StringBuffer sb = new StringBuffer("");
                String line = "";
                String NL = System.getProperty("line.separator");
                while ((line = in.readLine()) != null) {
                    sb.append(line + NL);
                }
                in.close();
                return sb.toString();

            } catch (Exception e) {
                return "Exception happened: " + e.getMessage();
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        protected void onProgressUpdate(Integer... progress) {
            //Se obtiene el progreso de la peticion
           //fede Log.w(APP_TAG,"Indicador de pregreso " + progress[0].toString());
        }

        protected void onPostExecute(String result) {
            //Se obtiene el resultado de la peticion Asincrona
            //fedeLog.w(APP_TAG,"Resultado obtenido " + result);
            processResult(result);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_enviar_datos, menu);
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
