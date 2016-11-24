package App;

import Bean.HelloBean;
import Bean.OtroBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        ApplicationContext context = getApplicationContext();
        HelloBean helloBean = (HelloBean) context.getBean("helloBean");
        OtroBean otroBean = helloBean.getOtroBean();

        otroBean.printHello();


    }

    private static ApplicationContext getApplicationContext() {

        return new ClassPathXmlApplicationContext("Spring-Module.xml");
    }
}
