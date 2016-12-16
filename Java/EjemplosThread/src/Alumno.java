public class Alumno extends Thread {
    String nombre;
    Nota nota;
    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public Alumno(String nombre, Nota nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public void run(){
        System.out.println ( nombre + " Esperado su nota" );
        nota.esperar(); // el alumno espera la nota
        System.out.println ( nombre + " recibio su nota");
    }
}
