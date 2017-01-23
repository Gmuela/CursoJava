package ejemplos;

import javax.ejb.Local;

@Local
public interface InterfaceLocalEJB {
    String saluda(String nombre);
}
