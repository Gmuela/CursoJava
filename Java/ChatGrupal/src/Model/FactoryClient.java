package Model;

public class FactoryClient {
    /*private static ClientReceiver clientReceiver;
    private static ClientTransmitter clientTransmitter;*/

    public static ClientReceiver createClientReceiver(String host) {
        return new ClientReceiver(host);
    }

    public static ClientTransmitter createClientTransmitter(String host) {
        return new ClientTransmitter(host);
    }

}
