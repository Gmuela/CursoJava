package ejerciciosMatrices;

public class Ejercicio1 {

    public int[][] matrizEnterosA = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
    public int[][] matrizEnterosB = {{1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};

    public int [][] matrizSuma = sumarMatrices(matrizEnterosA,matrizEnterosB);

    public static void main(String[] args){
        Ejercicio1 ej1 = new Ejercicio1();
        for (int[] ints : ej1.matrizSuma) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println("");
        }
    }

    private int[][] sumarMatrices(int[][] matrizEnterosA, int[][] matrizEnterosB) {

        int[][] matrizResultado = new int[4][4];

        for (int i = 0; i < matrizEnterosA.length; i++) {
            for(int j = 0; j < matrizEnterosA[i].length; j++){
                matrizResultado[i][j] = matrizEnterosA[i][j] + matrizEnterosB[i][j];
            }
        }

        return matrizResultado;
    }

}
