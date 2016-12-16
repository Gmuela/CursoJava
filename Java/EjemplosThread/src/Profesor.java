public class Profesor extends Thread {
    String nombre;
    Nota nota;

    public Profesor(String nombre, Nota nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public void run(){
        System.out.println ( " Voy a corregir los examenes");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println ( " Voy a poner la nota ");
        nota.dar (); // el profesor pone la nota del alumno
    }
}
