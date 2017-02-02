import Business.ParentBusiness;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
        ParentBusiness business = (ParentBusiness) ctx.getBean("Business");
        business.ant("Hola ant");
        business.foo("Hola foo");
    }
}
