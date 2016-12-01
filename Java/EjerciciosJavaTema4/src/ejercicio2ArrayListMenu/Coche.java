package ejercicio2ArrayListMenu;

public class Coche {

    private String matricula;
    private String marca;
    private String modelo;
    private int kilometros;

    public Coche(String matricula, String marca, String modelo, int kilometros) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometros = kilometros;
    }

    public Coche() {
    }

    public String toString() {

        String info;

        String matricula = "Matrícula:" + this.matricula;
        String marca = "Marca: " + this.marca;
        String modelo = "Modelo: " + this.modelo;
        String kilometros = "Kielómetros: " + this.kilometros;

        String separadorVertical = "\n";
        String separadorHorizontal = "---------------------------";

        info = separadorHorizontal + separadorVertical;
        info += matricula + separadorVertical + marca + separadorVertical + modelo + separadorVertical + kilometros + separadorVertical;
        info += separadorVertical;
        return info;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getKilometros() {
        return kilometros;
    }
}
