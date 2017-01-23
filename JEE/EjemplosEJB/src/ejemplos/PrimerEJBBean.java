package ejemplos;

import javax.ejb.Stateless;

@Stateless(name = "PrimerEJBEJB")
public class PrimerEJBBean implements InterfaceEJB, InterfaceLocalEJB{
    public String saluda(String nombre) {
        if (nombre == null) {
            return "Hola desconocido";
        }
        return "Hola " + nombre;
    }
}
