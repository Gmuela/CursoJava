package ejemplo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lanzador {
    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        Persona persona = (Persona) applicationContext.getBean("guille");
        Persona persona2 = (Persona) applicationContext.getBean("maria");
        System.out.println(persona);
        System.out.println(persona2);
    }

}
