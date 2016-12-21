package ClienteServidorTCP;

import java.io.*;
import java.net.Socket;

class ClienteTCP implements InterfaceTCP{
    private static final int Puerto = 6000;

    private ClienteTCP() {
        try {
            Socket socketCliente = new Socket(HOST, Puerto);

            escribirMensaje(socketCliente);

            leerMensaje(socketCliente);

            cerrarConexion(socketCliente);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cerrarConexion(Socket socketCliente){
        try {
            socketCliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void escribirMensaje(Socket socketCliente){
        OutputStream socketClienteOutputStream = null;
        try {
            socketClienteOutputStream = socketCliente.getOutputStream();
            DataOutputStream canalOutput = new DataOutputStream(socketClienteOutputStream);
            canalOutput.writeUTF("Hola servidor :D");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void leerMensaje(Socket socketCliente){
        InputStream socketClienteInputStream = null;
        try {
            socketClienteInputStream = socketCliente.getInputStream();
            DataInputStream canalInput = new DataInputStream(socketClienteInputStream);
            System.out.println(canalInput.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new ClienteTCP();
    }
}
