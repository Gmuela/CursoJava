package Business;

import org.springframework.stereotype.Component;

@Component("Business")
public class Business implements ParentBusiness {
    public void foo(String palabra) {
        System.out.println("*******************");
        System.out.println("Dentro de Business.foo()");
        System.out.println("*******************");
    }

    public void ant(String palabra) {
        System.out.println("*******************");
        System.out.println("Dentro de Business.ant()");
        System.out.println("*******************");
    }
}
