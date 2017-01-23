package negocio;

import javax.ejb.Remote;

@Remote
public interface RemoteGestionUsuariosBean {
    boolean login(String nombre, String password);
}
