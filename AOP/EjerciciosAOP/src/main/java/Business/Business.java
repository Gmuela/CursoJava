package Business;

import org.springframework.stereotype.Component;

@Component(value = "Business")
public class Business implements BusinessInterface {

	@Override
	public void foo() {
		System.out.println("*******************");
		System.out.println("Dentro de Negocio.foo()");
		System.out.println("*******************");
	}

	@Override
	public void ant() {
		System.out.println("*******************");
		System.out.println("Dentro de Negocio.ant()");
		System.out.println("*******************");
	}

	@Override
	public String fooReturn() {
		return "Soy fooReturn";
	}

	@Override
	public String antReturn() {
		return "Soy antReturn";
	}

	@Override
	public void throwBananas() throws Exception {
		throw new Exception("BANANAAAAAAAAAAAAA");
	}
}