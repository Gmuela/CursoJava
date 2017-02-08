package Beans;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class Contacto {

    private ObjectId _id;
    private String nombre;
    private String apellidos;
    private String dni;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaNacimiento;
    private String telefono;

    private List<Usuario> usuarios;


    public Document getDocument() {
        Document document = new Document();
        document.put("nombre", this.nombre);
        document.put("apellidos", this.apellidos);
        document.put("dni", this.dni);
        document.put("fechaNacimiento", this.fechaNacimiento.toString());
        document.put("telefono", this.telefono);
        for (Usuario usuario : usuarios) {
            document.put("usuarios", usuario.getDocument());
        }
        return document;
    }

    public Contacto() {
        //Dafault constructor
    }

    public Contacto(ObjectId _id, String nombre, String apellidos, String dni, LocalDate fechaNacimiento, String telefono, List<Usuario> usuarios) {
        this._id = _id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.usuarios = usuarios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
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

    public void addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }
}
