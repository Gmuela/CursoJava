package Negocio;

import org.springframework.stereotype.Component;

@Component
public class Business implements ParentBusiness {
    @Override
    public void foo(String foo) {
        System.out.println("*******************");
        System.out.println("Dentro de Negocio.foo()");
        System.out.println("*******************");
    }

    @Override
    public void ant(String ant) {
        System.out.println("*******************");
        System.out.println("Dentro de Negocio.ant()");
        System.out.println("*******************");
    }
}
