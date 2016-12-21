package ClienteServidorUDP;

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

        String[] mensajes = {"hola", "caranchoa", "tu puta madre", "tranquilo era broma"};

        for (String mensaje : mensajes) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cliente.enviar(mensaje, "Guillermo: ", "192.168.1.213");
            System.out.println(new String(cliente.recibir()));
        }

        cliente.cerrar();

    }


}
