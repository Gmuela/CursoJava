package example;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

    private String nombre;
    private String password;

    @Override
    public String execute() throws Exception {
        if(nombre == null || password == null){
            return LOGIN;
        } else if(nombre.equals("admin") && password.equals("admin")){
            return SUCCESS;
        } else{
            return LOGIN;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
