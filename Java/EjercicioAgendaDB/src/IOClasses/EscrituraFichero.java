package IOClasses;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscrituraFichero implements IOFichero {

    private String nombreFichero;
    private BufferedWriter bufferedWriter;

    public EscrituraFichero(String nombreFichero, Boolean addEnd) {
        this.nombreFichero = nombreFichero;
        FileWriter fileWriter = init(addEnd);
        this.bufferedWriter = new BufferedWriter(fileWriter);
    }

    private FileWriter init(Boolean addEnd) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(this.nombreFichero, addEnd);
        } catch (IOException e) {
            System.out.println("Error al inicializar FileWriter " + e);
        }

        return fileWriter;
    }

    public boolean escribirLinea(String linea) {
        boolean success = true;
        try {
            this.bufferedWriter.write(linea);
            this.bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Error en la escritura del archivo " + e);
            success = false;
        }

        return success;
    }

    @Override
    public void close() {
        try {
            this.bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error al cerra BufferedWriter " + e);
        }
    }
}
