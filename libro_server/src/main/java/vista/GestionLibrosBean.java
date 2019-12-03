package vista;


import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import negocio.GestionDatos;
import modelo.Autor;
import modelo.Categoria;
import modelo.Libro;

@ManagedBean
@SessionScoped
public class GestionLibrosBean {
	
	@Inject
	private GestionDatos gd;
	private Libro libro = new Libro();
	private List<Libro> libros;
	private List<Autor> autores;
	
	@PostConstruct
	public void init()
	{
		libro = new Libro();
		libro.addAutor(new Autor());
		libro.addCategoria(new Categoria());
		libros=gd.getLibros();
		
	}


	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	
	
	
	
	public GestionDatos getGd() {
		return gd;
	}



	public void setGd(GestionDatos gd) {
		this.gd = gd;
	}



	public String guardar()
	{
		System.out.print(libro);
		gd.guardarLibro(libro);
		init();
		libros = gd.getLibros();
		return "listar_libros";
		
	}
	
	public String mostrarAutores()
	{
		
		return "listar_autores";
		
	}
	
	public String mostrarCategorias()
	{
		
		return "listar_categorias";
		
	}
	

	public String addAutor()
	{
		libro.addAutor(new Autor());
		return null;
	}
	
	public String addCategoria()
	{
		libro.addCategoria(new Categoria());
		return null;
	}
	
}