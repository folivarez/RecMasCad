package com.example.fede.recmascad;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by fede on 01/05/2015.
 */
public class Victima {

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
    public String s_imagen;


    public Victima(String _altura, String _edad, String _sexo, String _piel, String _raza, String _peloTipo, String _peloColor, String _ojos,
                   String _cicatricesZona, String _cicatricesLugar, String _tatuajesZona, String _tatuajesLugar, String _dentadura, String _discapacidadZona,
                   String _discapacidadLugar, String _indumentariaZona, String _indumentariaColor, String _imagen) {
        this.s_altura = _altura;
        this.s_edad = _edad;
        this.s_sexo = _sexo;
        this.s_piel = _piel;
        this.s_raza = _raza;
        this.s_peloTipo = _peloTipo;
        this.s_peloColor = _peloColor;
        this.s_ojos = _ojos;
        this.s_cicatricesZona = _cicatricesZona;
        this.s_cicatricesLugar = _cicatricesLugar;
        this.s_tatuajesZona = _tatuajesZona;
        this.s_tatuajesLugar = _tatuajesLugar;
        this.s_dentadura = _dentadura;
        this.s_discapacidadZona = _discapacidadZona;
        this.s_discapacidadLugar = _discapacidadLugar;
        this.s_indumentariaZona = _indumentariaZona;
        this.s_indumentariaColor = _indumentariaColor;
        this.s_imagen = _imagen;
    }


    public String getS_altura() {
        return s_altura;
    }

    public void setS_altura(String s_altura) {
        this.s_altura = s_altura;
    }

    public String getS_edad() {
        return s_edad;
    }

    public void setS_edad(String s_edad) {
        this.s_edad = s_edad;
    }

    public String getS_sexo() {
        return s_sexo;
    }

    public void setS_sexo(String s_sexo) {
        this.s_sexo = s_sexo;
    }

    public String getS_piel() {
        return s_piel;
    }

    public void setS_piel(String s_piel) {
        this.s_piel = s_piel;
    }

    public String getS_raza() {
        return s_raza;
    }

    public void setS_raza(String s_raza) {
        this.s_raza = s_raza;
    }

    public String getS_peloTipo() {
        return s_peloTipo;
    }

    public void setS_peloTipo(String s_peloTipo) {
        this.s_peloTipo = s_peloTipo;
    }

    public String getS_peloColor() {
        return s_peloColor;
    }

    public void setS_peloColor(String s_peloColor) {
        this.s_peloColor = s_peloColor;
    }

    public String getS_ojos() {
        return s_ojos;
    }

    public void setS_ojos(String s_ojos) {
        this.s_ojos = s_ojos;
    }

    public String getS_cicatricesZona() {
        return s_cicatricesZona;
    }

    public void setS_cicatricesZona(String s_cicatricesZona) {
        this.s_cicatricesZona = s_cicatricesZona;
    }

    public String getS_cicatricesLugar() {
        return s_cicatricesLugar;
    }

    public void setS_cicatricesLugar(String s_cicatricesLugar) {
        this.s_cicatricesLugar = s_cicatricesLugar;
    }

    public String getS_tatuajesZona() {
        return s_tatuajesZona;
    }

    public void setS_tatuajesZona(String s_tatuajesZona) {
        this.s_tatuajesZona = s_tatuajesZona;
    }

    public String getS_tatuajesLugar() {
        return s_tatuajesLugar;
    }

    public void setS_tatuajesLugar(String s_tatuajesLugar) {
        this.s_tatuajesLugar = s_tatuajesLugar;
    }

    public String getS_dentadura() {
        return s_dentadura;
    }

    public void setS_dentadura(String s_dentadura) {
        this.s_dentadura = s_dentadura;
    }

    public String getS_discapacidadZona() {
        return s_discapacidadZona;
    }

    public void setS_discapacidadZona(String s_discapacidadZona) {
        this.s_discapacidadZona = s_discapacidadZona;
    }

    public String getS_discapacidadLugar() {
        return s_discapacidadLugar;
    }

    public void setS_discapacidadLugar(String s_discapacidadLugar) {
        this.s_discapacidadLugar = s_discapacidadLugar;
    }

    public String getS_indumentariaZona() {
        return s_indumentariaZona;
    }

    public void setS_indumentariaZona(String s_indumentariaZona) {
        this.s_indumentariaZona = s_indumentariaZona;
    }

    public String getS_indumentariaColor() {
        return s_indumentariaColor;
    }

    public void setS_indumentariaColor(String s_indumentariaColor) {
        this.s_indumentariaColor = s_indumentariaColor;
    }

    public String getS_imagen() {
        return s_imagen;
    }

    public void setS_imagen(String s_imagen) {
        this.s_imagen = s_imagen;
    }

    public String toJSON(){

        JSONObject jsonObject= new JSONObject();
        try {


            jsonObject.put("altura", getS_altura());
            jsonObject.put("edad", getS_edad());
            jsonObject.put("sexo", getS_sexo());
            jsonObject.put("piel", getS_piel());
            jsonObject.put("raza", getS_raza());
            jsonObject.put("peloTipo", getS_peloTipo());
            jsonObject.put("peloColor", getS_peloColor());
            jsonObject.put("ojos", getS_ojos());
            jsonObject.put("cicatricesZona", getS_cicatricesZona());
            jsonObject.put("cicatricesLugar", getS_cicatricesLugar());
            jsonObject.put("tatuajesZona", getS_tatuajesZona());
            jsonObject.put("tatuajesLugar", getS_tatuajesLugar());
            jsonObject.put("dentadura", getS_dentadura());
            jsonObject.put("discapacidadZona", getS_discapacidadZona());
            jsonObject.put("discapacidadLugar", getS_discapacidadLugar());
            jsonObject.put("indumentariaZona", getS_indumentariaZona());
            jsonObject.put("indumentariaColor", getS_indumentariaColor());
            jsonObject.put("imagen", getS_imagen());

            return jsonObject.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }



}
