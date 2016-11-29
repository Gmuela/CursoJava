package ejercicio1ArrayList;

public class Empleado {

    private String nif;
    private double sueldoNeto;
    private double pagoPorHoraExtra;
    private double horasExtras;
    private double porcentajeIrpf;
    private int numeroHijos;

    public Empleado(String nif, double sueldoNeto, double pagoPorHoraExtra, double horasExtras, int porcentajeIrpf, int numeroHijos) {
        this.nif = nif;
        this.sueldoNeto = sueldoNeto;
        this.pagoPorHoraExtra = pagoPorHoraExtra;
        this.horasExtras = horasExtras;
        this.porcentajeIrpf = porcentajeIrpf;
        this.numeroHijos = numeroHijos;
    }

    public String toString(){

        String nif = "NIF: " + this.getNif();
        String sueldoNeto = "Sueldo Neto: " + this.getSueldoNeto();
        String pagoPorHoraExtra = "Euros/Hora extra: " + this.getPagoPorHoraExtra();
        String horasExtras = "Horas extras realizadas: " + this.getHorasExtras();
        String irpf = "IRPF: " + this.getPorcentajeIrpf() + "%";
        String numeroHijos = "Número de hijos: " + this.getNumeroHijos();

        return nif + "\n" + sueldoNeto + "\n" + pagoPorHoraExtra + "\n" + horasExtras + "\n" + irpf + "\n" + numeroHijos + "\n\n";
    }

    public boolean equals(Empleado empleado) {
        boolean isEquals = false;

        if(this.getNif().equalsIgnoreCase(empleado.getNif())){
            isEquals = true;
        }

        return isEquals;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public double getSueldoNeto() {
        return sueldoNeto;
    }

    public void setSueldoNeto(double sueldoNeto) {
        this.sueldoNeto = sueldoNeto;
    }

    public double getPagoPorHoraExtra() {
        return pagoPorHoraExtra;
    }

    public void setPagoPorHoraExtra(double pagoPorHoraExtra) {
        this.pagoPorHoraExtra = pagoPorHoraExtra;
    }

    public double getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }

    public double getPorcentajeIrpf() {
        return porcentajeIrpf;
    }

    public void setPorcentajeIrpf(double porcentajeIrpf) {
        this.porcentajeIrpf = porcentajeIrpf;
    }

    public int getNumeroHijos() {
        return numeroHijos;
    }

    public void setNumeroHijos(int numeroHijos) {
        this.numeroHijos = numeroHijos;
    }
}
