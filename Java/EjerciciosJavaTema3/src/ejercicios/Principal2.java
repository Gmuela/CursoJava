package ejercicios;

class Alumno {
    String nombre = "Alumno 1";
    char grupo = 'A';

    char devolvergrupo() {
        return grupo;
    }

    void cambiargrupo(char nuevogrupo) {
        grupo = nuevogrupo;
    }

    void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Grupo: " + devolvergrupo());
    }
}

/*
    Objeto a1:
    ------------
    Nombre Alumno 1
    Grupo A

    Llamada al método prueba1



    Dentro del metodo
    Nombre Alumno 1
    Grupo B
    En main:Fuera ya del método prueba2

    Nombre Alumno 1
    Grupo B

*/

class Principal2 {
    public static void main(String[] args) {
        Alumno a1 = new Alumno();
        System.out.println("Objeto a1:\n-----------\n");
        a1.imprimir();
        System.out.println("\nLlamada al método prueba1(a1)\n");
        prueba1(a1);
        a1.imprimir();
        System.out.println(" ");
        Alumno a2 = new Alumno();
        System.out.println("Objeto a2:\n-----------\n");
        a2.imprimir();
        System.out.println("\nLlamada al método prueba2(a2)\n");
        prueba2(a2);
        System.out.println("\nEn main:Fuera ya del método prueba2. \n ");
        a2.imprimir();
    }

    static void prueba1(Alumno b) {
        b.cambiargrupo('B');
    }

    static void prueba2(Alumno b) {
        b = new Alumno();
        b.cambiargrupo('B');
        System.out.println("\n Dentro del método prueba2. \n");
        b.imprimir();
    }
}
