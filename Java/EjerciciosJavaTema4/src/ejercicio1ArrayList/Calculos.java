package ejercicio1ArrayList;

public class Calculos {

    public static double calculoEurosPorHoraExtra(Empleado empleado){

        double pagoPorHoraExtra = empleado.getPagoPorHoraExtra();
        double horasExtraRealizadas = empleado.getHorasExtras();

        return pagoPorHoraExtra * horasExtraRealizadas;
    }

    public static double calcularSueldoBruto(Empleado empleado){

        double sueldoNeto = empleado.getSueldoNeto();
        double irpf = comprobarIrpf(empleado);

        return sueldoNeto + ((sueldoNeto*irpf)/100);

    }

    public static double calcularRetenciones(Empleado empleado){

        double sueldoBruto = calcularSueldoBruto(empleado);
        double retenciones;

        double porcentajeIrpf = comprobarIrpf(empleado);

        retenciones = (sueldoBruto * porcentajeIrpf)/100;

        return retenciones;

    }

    private static double comprobarIrpf(Empleado empleado) {

        double irpfComprobado;

        int numeroHijos = empleado.getNumeroHijos();

        if(numeroHijos > 2){

            irpfComprobado = empleado.getPorcentajeIrpf()-2;

        }

        else if(numeroHijos <= 2 && numeroHijos > 0){

            irpfComprobado = empleado.getPorcentajeIrpf()-1;

        }

        else{
            irpfComprobado = empleado.getPorcentajeIrpf();

        }

        return irpfComprobado;
    }

}
