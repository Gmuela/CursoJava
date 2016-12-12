import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LectorFichero {

    private String nombreFichero;
    private final FileReader fileReader = initFileReader();

    private FileReader initFileReader() {

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(this.nombreFichero);
        } catch (FileNotFoundException e) {
            System.out.println("Error al inicializar FileReader " + e);
        }

        return fileReader;
    }

    private final BufferedReader bufferedReader = new BufferedReader(fileReader);

    public LectorFichero(String nombreFichero){

        this.nombreFichero = nombreFichero;
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


        String firstWord = null;

        try {

            FileReader fileReader = new FileReader(this.nombreFichero);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            String[] arrayOfWords = line.split(" ");

            firstWord = arrayOfWords[0];

        } catch (IOException e) {

            System.out.println("Error I/O" + e);
        }

        return firstWord;

    }

    public String leerCadena(String separador) {
        String firstWord = null;

        try {

            FileReader fileReader = new FileReader(this.nombreFichero);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            String[] arrayOfWords = line.split(separador);

            firstWord = arrayOfWords[0];

        } catch (IOException e) {

            System.out.println("Error I/O" + e);
        }

        return firstWord;
    }

}
