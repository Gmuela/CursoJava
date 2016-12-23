package Cliente;

import beans.AdditionInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AdditionClient {

    public static final String ROUTE = "C:\\Users\\curso mañana\\Desktop\\Trabajo\\Java\\EjerciciosJavaRMI\\java.policy";

    public static void main(String[] args) {
        System.setProperty("java.security.policy", ROUTE);
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Addition";
            Registry registry = LocateRegistry.getRegistry("192.168.1.211", AdditionInterface.PORT);
            AdditionInterface stub = (AdditionInterface) registry.lookup(name);
            int result = stub.add(134524522, 154645669);
            System.out.println("Result is: " + result);
        } catch (Exception e) {
            System.out.println("Addition exception: " + e);
        }
    }
}
