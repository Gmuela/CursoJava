package modelo;

import java.util.ArrayList;

import beans.Contacto;


public interface ContactoDao {

	public boolean guardarContacto(Contacto contacto);

	Contacto recuperarContacto(Integer id);

	ArrayList<Contacto> recuperarContactos();

	public void borrarContacto(Integer id);

	boolean modificarContacto(Contacto contacto);

}