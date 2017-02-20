package ejemplogoogleapi.cursomaana.example.com.ejemplostorage.model.dao;

import java.util.List;

import ejemplogoogleapi.cursomaana.example.com.ejemplostorage.beans.Usuario;

public interface UsuarioDAO {
    List<Usuario> selectAll();

    void insert(Usuario usuario);

    Usuario select(int idUsuario);

    void delete(Usuario usuarioBorrar);

    void update(Usuario usuarioActualizar);
}
