package ejercicio3;

public class Ejercicio3 {

    public static void main(String[] args){
        escribeNumerosPares();
    }

    private static void escribeNumerosPares() {
        for (int i = 0; i <= 100; i++) {
            if(isPar(i)){
               System.out.println(i);
            }
        }
    }

    private static boolean isPar(int i) {
        return i%2==0;
    }
}
