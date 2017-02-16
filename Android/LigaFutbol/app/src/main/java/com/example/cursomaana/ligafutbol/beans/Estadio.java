package com.example.cursomaana.ligafutbol.beans;

import android.net.Uri;

public class Estadio {
    private String nombre;
    private String urlInfo;
    private int imagenEstadio;

    public Estadio(String nombre, String urlInfo, int imagenEstadio) {
        this.nombre = nombre;
        this.urlInfo = urlInfo;
        this.imagenEstadio = imagenEstadio;
    }

    public Uri getUri(){
        return Uri.parse(urlInfo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlInfo() {
        return urlInfo;
    }

    public void setUrlInfo(String urlInfo) {
        this.urlInfo = urlInfo;
    }

    public int getImagenEstadio() {
        return imagenEstadio;
    }

    public void setImagenEstadio(int imagenEstadio) {
        this.imagenEstadio = imagenEstadio;
    }
}
