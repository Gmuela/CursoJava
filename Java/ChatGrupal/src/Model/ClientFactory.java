package Model;

public class ClientFactory {
    private static ClientReceiver clientReceiver;
    private static ClientTransmitter clientTransmitter;

    public static ClientReceiver createClientReceiver() {
        return new ClientReceiver("host");
    }
    public static ClientTransmitter createClientTransmitter(String host) {
        return new ClientTransmitter("host");
    }

}
