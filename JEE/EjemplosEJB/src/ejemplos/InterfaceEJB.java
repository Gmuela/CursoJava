package ejemplos;

import javax.ejb.Remote;

@Remote
public interface InterfaceEJB {
    String saluda(String nombre);
}
