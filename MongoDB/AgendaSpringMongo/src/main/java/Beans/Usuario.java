package Beans;

import org.bson.Document;
import org.bson.types.ObjectId;

public class Usuario {

    private ObjectId _id;
    private String nombre;
    private String email;
    private String password;

    public Document getDocument(){
        Document document = new Document();
        document.put("nombre",this.nombre);
        document.put("email",this.email);
        document.put("password",this.password);
        return document;
    }

    public Usuario() {
        //Default
    }

    public Usuario(ObjectId _id, String nombre, String email, String password) {
        this._id = _id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public ObjectId getId() {
        return this._id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
