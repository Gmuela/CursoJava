package ejercicio6;

public class Estudiante extends Persona {

    private String cursoMatriculado;

    public Estudiante(String nombre, String apellidos, String dni, String estadoCivil, String cursoMatriculado) {
        super(nombre, apellidos, dni, estadoCivil);
        this.cursoMatriculado = cursoMatriculado;
    }

    public String getCursoMatriculado() {
        return cursoMatriculado;
    }
}
