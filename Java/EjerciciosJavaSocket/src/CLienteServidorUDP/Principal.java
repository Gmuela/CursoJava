package CLienteServidorUDP;

public class Principal {

    public static void main(String[] args) {

        ClienteUDP cliente = new ClienteUDP();
        ServidorUDP servidor = new ServidorUDP();
        servidor.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cliente.enviar("soy el mensaje que enviaste y volvió del server", "localhost");
        System.out.println(new String(cliente.recibir()));

    }


}
