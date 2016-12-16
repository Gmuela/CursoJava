public class Centro {

    public static void main(String[] args){
        Nota nota = new Nota(10);
        Profesor p = new Profesor("Profe",nota);
        Alumno a1 = new Alumno("Alumno 1", nota);
        Alumno a2 = new Alumno("Alumno 2", nota);

        p.start();
        a1.start();
        a2.start();

        try {
            a1.join();
            a2.join();
            p.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Se cierra la escuela");
    }

}
