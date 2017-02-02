import Business.BusinessInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) throws Exception {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-context.xml");

		BusinessInterface businessInterface = appContext.getBean("Business", BusinessInterface.class);

		businessInterface.ant();
		businessInterface.foo();
		businessInterface.fooReturn();
		businessInterface.antReturn();
		businessInterface.throwBananas();

	}
}