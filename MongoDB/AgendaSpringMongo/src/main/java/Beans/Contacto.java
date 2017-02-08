package Beans;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Contacto {

    private ObjectId _id;
    private String nombre;
    private String apellidos;
    private String dni;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaNacimiento;
    private String telefono;

    private Usuario usuario;


    public Document getDocument(){
        Document document = new Document();
        document.put("nombre",this.nombre);
        document.put("apellidos",this.apellidos);
        document.put("dni",this.dni);
        document.put("fechaNacimiento",this.fechaNacimiento.toString());
        document.put("telefono",this.telefono);
        document.put("usuario",this.usuario.getDocument());
        return document;
    }

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

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
