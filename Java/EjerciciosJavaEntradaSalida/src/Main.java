public class Main {
    public static void main(String[] args){
        //lee();
        //escribe();
        //leeTeclado();
        //pruebaFinal();

    }

    private static void pruebaFinal() {
        Teclado teclado = new Teclado();
        EscrituraFichero escritor = new EscrituraFichero("Prueba.txt", false);
        LectorFichero lector = new LectorFichero("Prueba.txt");

        String cadena = teclado.leerCadena();
        escritor.escribirLinea(cadena);
        escritor.close();
        System.out.println(lector.leerLinea());
        lector.close();
    }

    private static void leeTeclado() {
        Teclado teclado = new Teclado();
        System.out.println(teclado.leerInt());
        System.out.println(teclado.leerDouble());
        System.out.println(teclado.leerCadena());
    }

    private static void escribe() {
        EscrituraFichero escritor = new EscrituraFichero("HolaMundoEscribir.txt", false);

        escritor.escribirLinea("Hola Mundo");
        escritor.escribirLinea("Adios Mundo Cruel");
        escritor.close();

        EscrituraFichero escritorAppend = new EscrituraFichero("HolaMundoEscribirAppend.txt", true);

        escritorAppend.escribirLinea("Hola Mundo");
        escritorAppend.escribirLinea("Adios Mundo Cruel");
        escritorAppend.close();
    }

    private static void lee() {
        LectorFichero lector = new LectorFichero("HolaMundo.txt");

        System.out.println(lector.leerLinea());
        System.out.println(lector.leerLinea());

        lector = resetearLector(lector);

        System.out.println(lector.leerCadena());
        System.out.println(lector.leerCadena());

        lector = resetearLector(lector);

        System.out.println(lector.leerCadenaSolucionDos());
        System.out.println(lector.leerCadenaSolucionDos());

        lector = resetearLector(lector);

        System.out.println(lector.leerCadena("o"));
        System.out.println(lector.leerCadena("o"));

        lector = resetearLector(lector);

        System.out.println(lector.leerCadenaSolucionDos('o'));
        System.out.println(lector.leerCadenaSolucionDos('o'));

        lector = resetearLector(lector);

        while (lector.leerLinea() != null){
            System.out.println(lector.leerLinea());
        }

        lector.close();
    }

    private static LectorFichero resetearLector(LectorFichero lector) {
        lector.close();
        lector = new LectorFichero("HolaMundo.txt");
        System.out.println("==========================");
        return lector;
    }
}
