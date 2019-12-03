package negocio;

import java.util.List;



import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.AutorDAO;
import datos.CategoriaDAO;
import datos.EditorialDAO;
import datos.LibroDAO;
import modelo.Editorial;
import modelo.Libro;
//import java.util.ArrayList;


@Stateless
public class GestionDatos{
	
	@Inject
	private LibroDAO daoLib;

	
	
	public void guardarLibro(Libro libro){
		
		if(daoLib.read(libro.getCodigo())==null)
		{
			daoLib.insert(libro);
		}
		else
		{
			daoLib.update(libro);
		}
		
	}
	
	public List<Libro> getLibros(){
		return daoLib.getLibros();
	}
	
	public List<Libro> getLibrosNombre(String filtro)
	{
		return daoLib.getLibrosNombre(filtro);
	}
	
	public void removeLibrosNombre(String filtro)
	{
		daoLib.remove(filtro);
	}
	
	


	//////////////////////////////////////////////////////////////////////////////

	
}
