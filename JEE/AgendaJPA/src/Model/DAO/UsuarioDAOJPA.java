package Model.DAO;

import Beans.Contacto;

import java.util.ArrayList;

public class UsuarioDAOJPA implements ContactoDAO {
    @Override
    public boolean guardarContacto(Contacto contacto) {
        return false;
    }

    @Override
    public Contacto recuperarContacto(String dni) {
        return null;
    }

    @Override
    public ArrayList<Contacto> listarContactos() {
        return null;
    }

    @Override
    public boolean borrarContacto(String id) {
        return false;
    }

    @Override
    public boolean modificarContacto(Contacto contacto) {
        return false;
    }

    @Override
    public ArrayList<Contacto> getContactosOf(String usuario) {
        return null;
    }

    @Override
    public ArrayList<Contacto> getContactosFromMonth(String nombreUsuario, String mes) {
        return null;
    }
}
