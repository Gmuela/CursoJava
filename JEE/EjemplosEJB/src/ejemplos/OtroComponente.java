package ejemplos;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local
@Stateless(name = "otroComponente")
public class OtroComponente {
    public String otroMetodo() {
        return "Hola";
    }
}
