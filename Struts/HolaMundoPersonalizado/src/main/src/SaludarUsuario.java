import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.time.LocalDate;

public class SaludarUsuario extends ActionSupport implements ModelDriven<Usuario> {

    private Usuario usuario = new Usuario();
    private LocalDate hoy;

    @Override
    public String execute() throws Exception {

        String result = SUCCESS;

        if(usuario.getNombre() == null || usuario.getEdad() == null){
            result = LOGIN;
        } else if(usuario.getEdad() < 18){
            addActionError("Eres menor de edad");
            result = LOGIN;
        }
        return result;
    }

    @Override
    public String toString() {
        return "SaludarUsuario";
    }

    public Usuario getModel() {
        return usuario;
    }

    public LocalDate getHoy() {
        return hoy;
    }

    public void setHoy(LocalDate hoy) {
        this.hoy = hoy;
    }
}
