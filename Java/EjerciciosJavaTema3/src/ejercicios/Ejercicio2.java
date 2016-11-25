package ejercicios;

class Ejercicio2 {
    public static void main(String[] args) {
        Clase2 obj1 = new Clase2(5, 4);
        System.out.print(obj1.modificar(4) +" ");
        Clase2 obj2 = new Clase2(5, 4);
        System.out.print(obj2.modificar(5) +" ");
        obj2 = obj1;
        System.out.print(obj2.modificar(5) +" ");
    }
}

class Clase2 {
    int p1, p2;

    public Clase2(int i, int j) {
        p1 = i;
        p2 = j;
    }

    public int modificar(int i) {
        p1 = p1 + i;
        p2 = p2 + i;
        System.out.print(p2 +" ");
        return p1;
    }
}

//La salida es: 8 9 9 10 13 14