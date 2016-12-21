package ClienteServidorTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class ServidorTCP implements InterfaceTCP {

    public ServidorTCP() {
        try {
            ServerSocket socketServidor = crearSocketServidor();

            for (int numeroCliente = 0; numeroCliente < 3; numeroCliente++) {

                Socket socketCliente = aceptarConexiones(socketServidor, numeroCliente);

                leerMensaje(socketCliente);

                escribirMensaje(numeroCliente, socketCliente);

                cerrarSocket(socketCliente);
            }
            System.out.println("Clientes Atendidos");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private ServerSocket crearSocketServidor() throws IOException {
        ServerSocket socketServidor = new ServerSocket(PUERTO);
        System.out.println("Escucho el puerto " + PUERTO);
        return socketServidor;
    }

    private void escribirMensaje(int numeroCliente, Socket socketCliente) throws IOException {
        OutputStream socketClienteOutputStream = socketCliente.getOutputStream();
        DataOutputStream canalOutput = new DataOutputStream(socketClienteOutputStream);
        canalOutput.writeUTF("Hola cliente " + numeroCliente);
    }

    private void leerMensaje(Socket socketCliente) throws IOException {
        InputStream socketClienteInputStream = socketCliente.getInputStream();
        DataInputStream canalInput = new DataInputStream(socketClienteInputStream);
        System.out.println(canalInput.readUTF());
    }

    private void cerrarSocket(Socket socketCliente) throws IOException {
        socketCliente.close();
    }

    private Socket aceptarConexiones(ServerSocket socketServidor, int numeroCliente) throws IOException {
        Socket socketCliente = socketServidor.accept();
        System.out.println("Sirvo al cliente " + numeroCliente);
        return socketCliente;
    }

    public static void main(String[] arg) {
        new ServidorTCP();
    }
}