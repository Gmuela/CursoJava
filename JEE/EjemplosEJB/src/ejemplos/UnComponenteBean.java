package ejemplos;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless(name = "unComponenteEJB")
public class UnComponenteBean {
    @EJB(beanName = "otroComponente")
    private OtroComponente dependencia;

    public String metodo(){
        return dependencia.otroMetodo();
    }
}
