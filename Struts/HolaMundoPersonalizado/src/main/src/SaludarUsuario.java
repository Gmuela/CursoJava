import com.opensymphony.xwork2.ActionSupport;

import java.time.LocalDate;

public class SaludarUsuario extends ActionSupport {

    //private Usuario usuario;

    private String nombre;
    private Integer edad;
    private String error = "";
    private LocalDate hoy;

    /*public Usuario getUsuario() {
        return usuario;
    }*/

    /*public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }*/

    @Override
    public String execute() throws Exception {

        String result = SUCCESS;

        if(nombre == null || edad == null){
            result = LOGIN;
        } else if(edad < 18){
            addActionError("Eres menor de edad");
            result = LOGIN;
        }
        return result;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public LocalDate getHoy() {
        return hoy;
    }

    public void setHoy(LocalDate hoy) {
        this.hoy = hoy;
    }
}
