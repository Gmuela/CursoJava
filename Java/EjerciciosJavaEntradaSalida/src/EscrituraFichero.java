import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscrituraFichero implements IOFichero {

    private String nombreFichero;
    private BufferedWriter bufferedWriter;

    public EscrituraFichero(String nombreFichero, Boolean addEnd) {
        this.nombreFichero = nombreFichero;
        FileWriter fileWriter = initFileWriter(addEnd);
        this.bufferedWriter = new BufferedWriter(fileWriter);
    }

    private FileWriter initFileWriter(Boolean addEnd) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(this.nombreFichero, addEnd);
        } catch (IOException e) {
            System.out.println("Error al inicializar FileWriter " + e);
        }

        return fileWriter;
    }

    public void escribirLinea(String linea) {
        try {
            this.bufferedWriter.write(linea);
            this.bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Error en la escritura del archivo " + e);
        }
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