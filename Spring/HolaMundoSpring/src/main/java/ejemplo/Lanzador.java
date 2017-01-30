package ejemplo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lanzador {
    public static void main(String[] args) {
//        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
//        Persona persona = (Persona) applicationContext.getBean("guille");
//        Persona persona2 = (Persona) applicationContext.getBean("maria");
//        PersonaFactoria personaFactoria = (PersonaFactoria) applicationContext.getBean("personaFactoria");
//        personaFactoria.setNombre("Factoria");
//        System.out.println(persona);
//        System.out.println(persona2);
//        System.out.println(personaFactoria);
//        PersonaDireccion personaDireccion = (PersonaDireccion) applicationContext.getBean("personaDireccion");
//        System.out.println(personaDireccion);

        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        PersonaDireccion personaDireccion = applicationContext.getBean(PersonaDireccion.class);
        String nombre = personaDireccion.getNombre();
        System.out.println(nombre);
        System.out.println(personaDireccion.getDireccion());
    }

}
