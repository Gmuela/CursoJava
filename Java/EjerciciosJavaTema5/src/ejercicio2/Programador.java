package ejercicio2;

public class Programador extends Empleado {

    private Integer lineasDeCodigoPorHora;
    private String lenguajeDominante;

    public Programador() {
    }

    public Programador(String nombre, String nif, Integer edad, Boolean isCasado, Double salario, Integer lineasDeCodigoPorHora, String lenguajeDominante) {
        super(nombre, nif, edad, isCasado, salario);
        this.lineasDeCodigoPorHora = lineasDeCodigoPorHora;
        this.lenguajeDominante = lenguajeDominante;
    }

    public String toString() {
        String infoProgramador = super.toString();

        String lineasHora = "Líneas de código/hora: " + this.lineasDeCodigoPorHora;
        String lenguaje = "Lenguaje dominante: " + this.lenguajeDominante;

        String separador = "\n";

        infoProgramador += separador+ "Como programador tiene: " + separador + lineasHora + separador + lenguaje;

        return infoProgramador;
    }

    public Integer getLineasDeCodigoPorHora() {
        return lineasDeCodigoPorHora;
    }

    public String getLenguajeDominante() {
        return lenguajeDominante;
    }
}
