package negocio;

import javax.ejb.Stateless;

@Stateless(name = "GestionUsuariosEJB")
public class GestionUsuariosBean implements RemoteGestionUsuariosBean {
    public GestionUsuariosBean() {
    }

    @Override
    public boolean login(String nombre, String password) {

        boolean checked=false;

        if(nombre.equals("admin")&&password.equals("pass")){
            checked=true;
        }

        return checked;
    }
}
