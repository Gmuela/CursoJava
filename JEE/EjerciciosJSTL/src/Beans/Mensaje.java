package Beans;


import java.util.ArrayList;

public class Mensaje {
    private String texto;
    private ArrayList<String> listaTexto= new ArrayList<String>();

    public Mensaje(String texto) {
        this.texto = texto;
    }

    public Mensaje() {
        listaTexto.add("Hola");
        listaTexto.add("k");
        listaTexto.add("ase");
        listaTexto.add("yo");
        listaTexto.add("aquí");
        listaTexto.add("viendo");
        listaTexto.add("tu");
        listaTexto.add("careto");
        listaTexto.add("jeje");
        listaTexto.add("salu2");
        listaTexto.add(":D");
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public ArrayList<String> getListaTexto() {
        return listaTexto;
    }

    public void setListaTexto(ArrayList<String> listaTexto) {
        this.listaTexto = listaTexto;
    }
}
