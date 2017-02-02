import Negocio.Business;
import Negocio.ParentBusiness;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
        ParentBusiness business = ctx.getBean(Business.class);
        business.ant("ant");
        business.foo("foo");
    }
}
