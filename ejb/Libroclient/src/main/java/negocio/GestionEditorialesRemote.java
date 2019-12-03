package negocio;

import java.util.List;

import javax.ejb.Remote;

import modelo.Autor;
import modelo.Categoria;
import modelo.Editorial;
import modelo.Libro;

public interface GestionEditorialesRemote {
	
	public void guardarEditorial(String codigo, String nombre, String ciudad);
	public List<Editorial> getEditoriales();

}
