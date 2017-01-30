package ejemplo;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class PersonaFactoria {
    private static PersonaFactoria instancia= null;
    private String nombre;
    private PersonaFactoria(){
        System.out.println("Construyendo por Constructor");
    }
    static{
        instancia = new PersonaFactoria();
    }
    public static PersonaFactoria getInstance(){
        System.out.println("Construyendo via getInstance");
        return instancia;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

