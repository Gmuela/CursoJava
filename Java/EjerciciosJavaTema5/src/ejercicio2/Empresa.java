package ejercicio2;

import java.util.ArrayList;

public class Empresa {

    public static void main(String[] args){
        Programador programadorGuai = new Programador("Guillermo", "0Y", 24, false, 25000.0, 700, "Java");
        Programador programadorNiapa = new Programador("Eustaquio", "3P", 39, true, 18000.0, 900, "PHP");
        Empleado empleadoCualquiera = new Empleado("Pepe", "5K", 29, true, 12000.0);

        ArrayList<Empleado> empleados = new ArrayList<>();

        empleados.add(programadorGuai);
        empleados.add(programadorNiapa);
        empleados.add(empleadoCualquiera);


        for (Empleado empleado : empleados) {
                System.out.println(empleado.toString());
            System.out.println();
        }
    }

}
