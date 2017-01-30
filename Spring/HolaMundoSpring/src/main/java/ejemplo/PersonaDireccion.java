package ejemplo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PersonaDireccion {
    private String nombre;
    private int edad;
    private float altura;
    @Autowired
    private Direccion direccion;

    public PersonaDireccion() {
        //Default
    }
//
//    public PersonaDireccion(String nombre, float altura, int edad, Direccion direccion) {
//        this.nombre = nombre;
//        this.edad = edad;
//        this.altura = altura;
//        this.direccion = direccion;
//    }

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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }


    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
