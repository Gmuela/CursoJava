package CLienteServidorUDP;

public class Principal {

    public static void main(String[] args) {

        ClienteUDP cliente = new ClienteUDP();
        ServidorUDP servidor = new ServidorUDP();
        servidor.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cliente.enviar("hola", "localhost");

    }


}
