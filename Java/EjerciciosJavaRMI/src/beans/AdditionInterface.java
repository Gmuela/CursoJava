package beans;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdditionInterface extends Remote {
    int PORT = 1600;
    int add(int a,int b) throws RemoteException;
}
