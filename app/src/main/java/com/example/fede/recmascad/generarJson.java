package com.example.fede.recmascad;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by fede on 01/05/2015.
 */
public class generarJson {

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

    public JSONObject jSonVictima(ArrayList a){

    ArrayList<String> sArrayList = new ArrayList<String>();
        sArrayList = a;

        JSONObject json = new JSONObject();
        JSONObject victimaJson = new JSONObject();

        try {
            victimaJson.put("altura" , sArrayList.get(1));
            victimaJson.put("edad" , sArrayList.get(2));
            victimaJson.put("sexo" , sArrayList.get(3));
            victimaJson.put("piel" , sArrayList.get(4));
            victimaJson.put("raza" , sArrayList.get(5));
            victimaJson.put("peloTipo" , sArrayList.get(6));
            victimaJson.put("peloColor" , sArrayList.get(7));
            victimaJson.put("ojos" , sArrayList.get(8));
            victimaJson.put("cicatricesZona" , sArrayList.get(9));
            victimaJson.put("cicatricesLugar" , sArrayList.get(10));
            victimaJson.put("tatuajesZona" , sArrayList.get(11));
            victimaJson.put("tatuajesLugar" , sArrayList.get(12));
            victimaJson.put("dentadura" , sArrayList.get(13));
            victimaJson.put("discapacidadZona" , sArrayList.get(14));
            victimaJson.put("discapacidadLugar" , sArrayList.get(15));
            victimaJson.put("indumentariaZona" , sArrayList.get(16));
            victimaJson.put("indumentariaColor" , sArrayList.get(17));

            json.put("victima", victimaJson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }

}
