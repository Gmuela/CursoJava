package ejercicio6;

public class Estudiante extends Persona {

    private String cursoMatriculado;

    public Estudiante(String nombre, String apellidos, String dni, String estadoCivil, String cursoMatriculado) {
        super(nombre, apellidos, dni, estadoCivil);
        this.cursoMatriculado = cursoMatriculado;
    }

    public String toString() {

        String info = super.toString();

        String separador = "\n";
        String cursoMatriculado = "Curso Matriculado: " + this.cursoMatriculado;

        info += separador + cursoMatriculado;

        return info;
    }

    public String getCursoMatriculado() {
        return cursoMatriculado;
    }

    public void setCursoMatriculado(String cursoMatriculado) {
        this.cursoMatriculado = cursoMatriculado;
    }
}
