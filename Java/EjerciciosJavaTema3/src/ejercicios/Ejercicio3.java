package ejercicios;

class Ejercicio3 {
    public static void main(String[] args) {
        Clase3 obj1 = new Clase3(7);
        Clase3 obj2 = new Clase3(9);
        obj2 = obj1;
        System.out.print(obj1.valorprop() + " ");
        System.out.print(obj2.valorprop() + " ");
    }
}

class Clase3 {
    static int prop = 0;

    public Clase3(int valor) {
        prop = valor;
    }

    public int valorprop() {
        return prop;
    }
}

//La salida es: 9 9 (prop es estático)