package ejercicio6;

import java.util.ArrayList;

public class Centro {

    public static void main(String[] args){
        ArrayList<Empleado> empleados = new ArrayList<>();

        Empleado profesor1 = new Profesor("Guille", "Muela", "00Y", "casado", 1990, 10, "informatica");
        Empleado profesor2 = new Profesor("Maria", "Calvo", "00V", "casado", 2010, 11, "biosanidad");
        Empleado personalServicio1 = new PersonalServicio("Bruno", "Muela", "00I", "soltero", 2000, 3, "4A");
        Empleado personalServicio2 = new PersonalServicio("Marijose", "Lopez", "00H", "casado", 2004, 9, "6B");

        ((Profesor) profesor1).setDepartamento("Nuevo Departamento");
        ((PersonalServicio)personalServicio1).setSeccionAsignada("Nueva Sección");

        empleados.add(profesor1);
        empleados.add(profesor2);
        empleados.add(personalServicio1);
        empleados.add(personalServicio2);

        CalculosSalariales calculosSalariales = new CalculosSalariales();

        for (Empleado empleado : empleados) {
            System.out.println(empleado.toString() + "\n" + "Salario: " + calculosSalariales.calcularSalario(empleado));
            System.out.println("\n");
        }

        empleados.get(0).setNumeroDespacho(99);

        ArrayList<Persona> personas = new ArrayList<>(empleados);

        Estudiante estudianteGato = new Estudiante("Rocko", "Alicates", "00CAT", "gato", "Artes Gatunas");
        Estudiante estudianteNuevo = new Estudiante("Rocko", "Alicates", "00CAT", "gato", "Artes Gatunas");

        estudianteNuevo.setCursoMatriculado("Nuevo Curso");

        personas.add(estudianteGato);
        personas.add(estudianteNuevo);
        personas.get(0).setEstadoCivil("Nuevo estado civil");

        System.out.println("==================================================");

        for (Persona persona : personas) {
            System.out.println(persona.toString());
            System.out.println("\n");
        }

    }
}
