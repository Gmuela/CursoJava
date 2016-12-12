public class Main {
    public static void main(String[] args){
        LectorFichero lector = new LectorFichero("HolaMundo.txt");

        System.out.println(lector.leerLinea());
        System.out.println(lector.leerLinea());
    }
}
