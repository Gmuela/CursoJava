package ejemplo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Persona implements Serializable {

    private String nombre;
    private int edad;
    private float altura;
    private Persona pareja;
    private List<Persona> amigos;
    private List<String> colores;
    private Map<String,String> emails;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public Persona getPareja() {
        return pareja;
    }

    public void setPareja(Persona pareja) {
        this.pareja = pareja;
    }

    public List<Persona> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Persona> amigos) {
        this.amigos = amigos;
    }

    public List<String> getColores() {
        return colores;
    }

    public void setColores(List<String> colores) {
        this.colores = colores;
    }

    public Map<String, String> getEmails() {
        return emails;
    }

    public void setEmails(Map<String, String> emails) {
        this.emails = emails;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
