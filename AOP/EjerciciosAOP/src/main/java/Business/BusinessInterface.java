package Business;

import org.springframework.stereotype.Component;

@Component
public interface BusinessInterface {

	void foo();
	void ant();
	String fooReturn();
	String antReturn();
	void throwBananas() throws Exception;
}