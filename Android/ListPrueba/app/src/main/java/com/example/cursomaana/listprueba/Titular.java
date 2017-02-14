package com.example.cursomaana.listprueba;

/**
 * Created by curso mañana on 14/02/2017.
 */
public class Titular {

    private String titular;
    private String subtitular;

    public Titular(String titular, String subtitular) {
        this.titular = titular;
        this.subtitular = subtitular;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getSubtitular() {
        return subtitular;
    }

    public void setSubtitular(String subtitular) {
        this.subtitular = subtitular;
    }
}
