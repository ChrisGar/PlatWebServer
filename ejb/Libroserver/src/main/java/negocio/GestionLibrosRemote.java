package negocio;

import java.util.List;

import javax.ejb.Remote;

import modelo.Autor;
import modelo.Categoria;
import modelo.Editorial;
import modelo.Libro;

@Remote
public interface GestionLibrosRemote {
	
	public void guardarLibro(String codigo, String nombre, Autor autor, Categoria categoria, Editorial editorial);
	public List<Libro> getLibros();

}
