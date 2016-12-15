import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LectorFichero implements IOFichero {

    private String nombreFichero;
    private BufferedReader bufferedReader;
    private String content;
    private int indexLeerCadena;
    private int indexLeerCadenaSeparador;

    public LectorFichero(String nombreFichero) {

        this.nombreFichero = nombreFichero;
        FileReader fileReader = initFileReader();
        this.bufferedReader = new BufferedReader(fileReader);
        this.content = "";
        this.indexLeerCadena = 0;
        this.indexLeerCadenaSeparador = 0;
    }

    private FileReader initFileReader() {

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(this.nombreFichero);
        } catch (FileNotFoundException e) {
            System.out.println("Error al inicializar FileReader " + e);
        }

        return fileReader;
    }

    public String leerLinea() {

        String line = null;

        try {

            line = bufferedReader.readLine();

        } catch (IOException e) {

            System.out.println("Error I/O" + e);
        }

        return line;
    }

    public String leerCadena() {

        String word;

        if (contentIsVoid()) {
            readAndSaveInContent();
        }

        word = content.split(" ")[this.indexLeerCadena];
        indexLeerCadena++;

        return word;

    }

    public String leerCadena(String separador) {

        String word;

        if (contentIsVoid()) {
            readAndSaveInContent();
        }

        word = content.split(separador)[this.indexLeerCadenaSeparador];
        indexLeerCadenaSeparador++;

        return word;
    }

    public String leerCadenaSolucionDos() {

        String word = "";
        char espacio = 32;
        int read = 0;

        do {
            try {
                read = this.bufferedReader.read();
                word += (char) read;
            } catch (IOException e) {
                System.out.println("Error de lectura " + e);
            }
        } while (read != espacio);

        return word;

    }

    public String leerCadenaSolucionDos(char separador) {

        String word = "";
        char read = 0;

        try {
            while (isNotEqual(read, separador)) {
                read = (char) this.bufferedReader.read();

                if(isNotEqual(read, separador)){
                    word += (char) read;
                }
            }
        } catch (IOException e) {
            System.out.println("Error de lectura " + e);
        }

        return word;
    }

    private boolean isNotEqual(char read, char separador) {
        return read != separador;
    }

    private boolean contentIsVoid() {
        return this.content.equals("");
    }

    private void readAndSaveInContent() {
        String line = "";

        do {
            try {
                line = bufferedReader.readLine();
                this.content += line;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (line != null);
    }

    @Override
    public void close() {
        try {
            this.bufferedReader.close();
            this.content = "";
            this.indexLeerCadena = 0;
        } catch (IOException e) {
            System.out.println("El cierre del BufferedReader falló " + e);
        }
    }
}