package negocio;

import java.util.List;

import javax.ejb.Remote;

import modelo.Autor;
import modelo.Categoria;
import modelo.Editorial;
import modelo.Libro;

public interface GestionAutoresRemote {
	
	public void guardarAutor(String codigo, String nombre);
	public List<Autor> getAutores();

}

