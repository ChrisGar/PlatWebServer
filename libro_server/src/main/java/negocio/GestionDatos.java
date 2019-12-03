package negocio;

import java.util.List;



import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.AutorDAO;
import datos.CategoriaDAO;
import datos.EditorialDAO;
import datos.LibroDAO;
import modelo.Autor;
import modelo.Categoria;
import modelo.Editorial;
import modelo.Libro;
//import java.util.ArrayList;


@Stateless
public class GestionDatos{
	
	@Inject
	private LibroDAO daoLib;
	@Inject
	private AutorDAO daoAut;
	@Inject
	private CategoriaDAO daoCat;

	
	
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

	public List<Autor> getAutores(){
		return daoAut.getAutores();
	}
	
	public List<Categoria> getCategorias(){
		return daoCat.getCategorias();
	}
	
	public List<Libro> getLibrosNombre(String filtro)
	{
		return daoLib.getLibrosNombre(filtro);
	}
	
	public void removeLibrosNombre(String filtro)
	{
		daoLib.remove(filtro);
	}

	public LibroDAO getDaoLib() {
		return daoLib;
	}

	public void setDaoLib(LibroDAO daoLib) {
		this.daoLib = daoLib;
	}

	public AutorDAO getDaoAut() {
		return daoAut;
	}

	public void setDaoAut(AutorDAO daoAut) {
		this.daoAut = daoAut;
	}

	public CategoriaDAO getDaoCat() {
		return daoCat;
	}

	public void setDaoCat(CategoriaDAO daoCat) {
		this.daoCat = daoCat;
	}
	
	

	
}
