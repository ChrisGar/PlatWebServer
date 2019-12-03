package negocio;

import java.util.List;


import javax.ejb.Remote;

import modelo.Autor;
@Remote
public interface GestionAutoresRemote {
	
	public void guardarAutor(String codigo, String nombre);
	public List<Autor> getAutores();

}
