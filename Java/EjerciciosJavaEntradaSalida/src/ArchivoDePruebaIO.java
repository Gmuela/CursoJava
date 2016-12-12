import java.io.*;

public class ArchivoDePruebaIO {

    private static FileReader fileReader;
    private static FileWriter fileWriter;
    private static FileWriter fileWriterConAppend;

    public static void main(String[] args) {

        comoLeerConBufferedReader();
        comoEscribirConBufferedWriter();


    }

    private static void comoLeerConBufferedReader() {
        /*************************CÓMO LEER CON FILE READER Y BUFFERED READER*****************************/

        //PRIMERO INSTANCIAMOS EL FILE READER EL CUAL RECIBE POR PARÁMETRO EL NOMBRE O RUTA DEL ARCHIVO
        //ESTA INSTANCIACIÓN PUEDE DAR UN FILENOTFOUNDEXCEPTION, USAMOS UN TRY/CATCH

        String ruta = "Una ruta cualquiera o nombre cualquiera";

        try {
            fileReader = new FileReader(ruta);
        } catch (FileNotFoundException e) {
            System.out.println("Ha fallado la instacia de FileReader " + e);
        }

        //A CONTINUACIÓN INSTANCIAMOS UN BUFFERED READER QUE RECIBE POR PARÁMETRO EL FILE READER ANTES INSTANCIADO

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        //AHORA PODEMOS ACCEDER A LOS MÉTODOS QUE QUERAMOS DE BUFFERED READER, POR EJEMPLO, LEER UNA LÍNEA Y LUEGO CERRARLO:

        try {
            System.out.println(bufferedReader.readLine());
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Ha fallado la lectura del archivo "+ ruta + ": " + e);
        }
    }

    private static void comoEscribirConBufferedWriter() {
        /*************************CÓMO ESCRIBIR CON FILE WRITER Y BUFFERED WRITER**************************/

        //PRIMERO INSTANCIAMOS EL FILE WRITER EL CUAL RECIBE POR PARÁMETRO EL NOMBRE O RUTA DEL ARCHIVO
        //SI QUEREMOS QUE AL ESCRIBIR NUESTRO ARCHIVO NO SE SOBRESCRIBA, SI NO QUE SE AÑADA AL FINAL, PASAMOS UN SEGUNDO PARÁMETRO BOOLEAN LLAMADO APPEND
        //ESTA INSTANCIACIÓN PUEDE DAR UN IOEXCEPTION, USAMOS UN TRY/CATCH

        String ruta = "Una ruta cualquiera o nombre cualquiera";

        try {
            fileWriter = new FileWriter(ruta);
            fileWriterConAppend = new FileWriter(ruta, true);
        } catch (IOException e) {
            System.out.println("Ha fallado la instacia de FileWriter " + e);
        }

        //A CONTINUACIÓN INSTANCIAMOS DOS BUFFERED WRITER QUE RECIBEN POR PARÁMETRO LOS FILE WRITER ANTES INSTANCIADOS

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        BufferedWriter bufferedWriterConAppend = new BufferedWriter(fileWriterConAppend);

        //AHORA PODEMOS ACCEDER A LOS MÉTODOS QUE QUERAMOS DE BUFFERED WRITER, POR EJEMPLO, ESCRIBIR UNA LÍNEA Y LUEGO CERRARLO. EN EL CASO DEL QUE TIENE APPEND PODRÍAMOS
        //ESCRIBIR DOS LÍNEAS SEGUIDAS:

        try {
            bufferedWriter.write("Algo para escribir");
            bufferedWriter.close();

            bufferedWriterConAppend.write("Algo para escribir primero");
            bufferedWriterConAppend.write("Algo para escribir después");
            bufferedWriterConAppend.close();

        } catch (IOException e) {
            System.out.println("Ha fallado la lectura del archivo "+ ruta + ": " + e);
        }
    }

}
