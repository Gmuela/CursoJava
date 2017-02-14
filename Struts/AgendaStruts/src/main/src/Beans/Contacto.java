package Beans;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "id_contacto", sequenceName = "contacto_sequence")
public class Contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_contacto")
    private Integer id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String fechaNacimiento;
    private String telefono;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Usuario usuario;

    public Contacto() {
        //Dafault constructor
    }

    public Contacto(String nombre, String apellidos, String dni, String fechaNacimiento, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    public Contacto(String nombre, String apellidos, String dni, String fechaNacimiento, String telefono, Usuario usuario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
