package ejercicio1ArrayList;

import java.util.ArrayList;

public class Principal {

    private ArrayList<Empleado> empleados;

    public static void main(String[] args) {
        Principal principal = new Principal();
        System.out.println("==========Crea ArrayList===========");
        principal.addEmpleados();
        System.out.println("==========Muestra los empledos del ArrayList===========");
        principal.mostrarEmpleados();
        System.out.println("==========Borro el empleado con NIF 08848608P===========");
        principal.borrarEmpleado(principal.buscarEmpleadoConNIF("08848608P"));
        System.out.println("==========Muestra los empledos del ArrayList===========");
        principal.mostrarEmpleados();
        System.out.println("==========Busco el empleado con NIF 09049609Y===========");
        Empleado empleado = principal.buscarEmpleadoConNIF("09049609Y");
        System.out.println("==========Muestro la media de hijos===========");
        principal.mostrarMediaDeHijos();
        System.out.println("==========Muestro el empleado buscado antes(NIF 09049609Y)===========");
        principal.mostrarEmpleado(empleado);
        System.out.println("==========Muestro el sueldo bruto del empleado buscado antes(NIF 09049609Y)===========");
        double sueldoBruto = Calculos.calcularSueldoBruto(empleado);
        System.out.println(sueldoBruto);
        System.out.println("==========Muestro el dinero/hora extra del empleado buscado antes(NIF 09049609Y)===========");
        double eurosPorHoraExtra = Calculos.calculoEurosPorHoraExtra(empleado);
        System.out.println(eurosPorHoraExtra);
        System.out.println("==========Muestro las retenciones del empleado buscado antes(NIF 09049609Y)===========");
        double retenciones = Calculos.calcularRetenciones(empleado);
        System.out.println(retenciones);
    }

    public void mostrarEmpleado(Empleado empleado) {
        System.out.println(empleado.toString());
    }

    private void mostrarMediaDeHijos() {

        int totalHijos = 0;

        for (Empleado empleado : this.empleados) {
            totalHijos += empleado.getNumeroHijos();
        }

        int mediaHijos = totalHijos / this.empleados.size();

        System.out.println("La media de hijos es: " + mediaHijos);
    }

    private Empleado buscarEmpleadoConNIF(String nif) {

        Empleado empleadoEncontrado = null;

        for (Empleado empleado : this.empleados) {
            if (empleado.getNif().equalsIgnoreCase(nif)) {
                empleadoEncontrado = empleado;
            }
        }

        return empleadoEncontrado;
    }

    private void borrarEmpleado(Empleado empleado) {

        this.empleados.remove(empleado);

    }

    private void mostrarEmpleados() {
        System.out.println(empleados);
    }

    private void addEmpleados() {

        Empleado guillermo = new Empleado("09049609Y", 15000.00, 15.5, 3.0, 4, 0);
        Empleado jose = new Empleado("08848608P", 12000.00, 13.0, 4.0, 6, 2);
        Empleado maria = new Empleado("09689046O", 18000.00, 10.0, 1.0, 10, 0);
        Empleado bruno = new Empleado("98602354L", 35000.00, 25.5, 0.0, 17, 6);

        this.empleados = new ArrayList<Empleado>();

        empleados.add(guillermo);
        empleados.add(jose);
        empleados.add(maria);
        empleados.add(bruno);
    }
}
