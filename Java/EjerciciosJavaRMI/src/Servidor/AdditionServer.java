package Servidor;

import beans.AdditionInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class AdditionServer {

    private static final String ROUTE = "file:///C:/Users/curso20%mañana/Desktop/Trabajo/Java/EjerciciosJavaRMI/src/Servidor";
    private static final String POLICY = "file:///C:/Users/curso20%mañana/Desktop/Trabajo/Java/EjerciciosJavaRMI/java.policy";

    public static void main(String[] argv) {

        System.setProperty("java.rmi.server.codebase", ROUTE);
        System.setProperty("java.security.policy", POLICY);

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            String name = "Addition";
            Addition add = new Addition();

            AdditionInterface skeleton = (AdditionInterface) UnicastRemoteObject.exportObject(add, 0);

            Registry registry = LocateRegistry.createRegistry(AdditionInterface.PORT);
            //Registry registry = LocateRegistry.getRegistry("localhost",AdditionInterface.PORT);
            registry.rebind(name, skeleton);

            System.out.println("Addition Server is ready.");

        } catch (Exception e) {
            System.out.println("Addition Server failed: " + e);
        }
    }
}