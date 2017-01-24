package Beans;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name = "id_contacto", sequenceName = "contacto_sequence")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_contacto")
    private Integer id;
    private String nombre;
    private String apellidos;
    private String dni;
    private LocalDate fechaNacimiento;
    private String telefono;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Usuario usuario;

    public Contacto() {
        //Dafault constructor
    }


    public Contacto(String nombre, String apellidos, String dni, LocalDate fechaNacimiento, String telefono, Usuario usuario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String toString() {

        String info;

        String nombre = "Nombre: " + this.nombre;
        String apellidos = "Apellidos: " + this.apellidos;
        String dni = "DNI: " + this.dni;
        String fecha = "Fecha: " + this.fechaNacimiento.toString();
        String telefono = "Teléfono: " + this.telefono;

        String separadorVertical = "\n";

        info = nombre + separadorVertical + apellidos + separadorVertical + dni + separadorVertical + fecha + separadorVertical + telefono;
        return info;
    }

    public String returnData() {

        String info;

        String nombre = this.nombre;
        String apellidos = this.apellidos;
        String dni = this.dni;
        String fecha = this.fechaNacimiento.toString();
        String telefono = this.telefono;

        String separadorVertical = " ";

        info = nombre + separadorVertical + apellidos + separadorVertical + dni + separadorVertical + fecha + separadorVertical + telefono;
        return info;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
