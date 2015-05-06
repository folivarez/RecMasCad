package com.example.fede.recmascad;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


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

    Button.OnClickListener buttonSendOnClickListener
            = new Button.OnClickListener(){

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub




            ExecuteTask lp = new ExecuteTask();
            lp.execute();


        }};





        class ExecuteTask extends AsyncTask<String, String, String> {
            @Override
            protected void onPreExecute(){
                super.onPreExecute();

            }

            protected String doInBackground(String ... args){

                return null;
            }

            @Override
            protected void onPostExecute(String file_url){

                runOnUiThread(new Runnable() {
                    Socket socket = null;
                    DataOutputStream dataOutputStream = null;
                    ObjectOutputStream objectOutputStream = null;
                    DataInputStream dataInputStream = null;
                    public void run(){
                        try {
                            socket = new Socket("104.236.125.167", 6004);
                            //dataOutputStream = new DataOutputStream(socket.getOutputStream());
                            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                            dataInputStream = new DataInputStream(socket.getInputStream());
                            //dataOutputStream.writeUTF(textOut.getText().toString());
                            //dataOutputStream.writeUTF(String.valueOf(aVictima));
                            //dataOutputStream.writeUTF(String.valueOf(aVictima));
                            objectOutputStream.writeObject(aVictima);

                            textIn.setText(dataInputStream.readUTF());

                            socket.close();
                        } catch (UnknownHostException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                });
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
