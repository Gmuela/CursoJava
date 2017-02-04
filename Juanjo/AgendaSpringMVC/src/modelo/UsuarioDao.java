package modelo;

import beans.Usuario;

public interface UsuarioDao {
	
	public void registrarUsuario(Usuario usuario);
	
    Usuario recuperarUsuario(String nombre);
    
    
    
    
}
