package negocio;

import java.util.List;

import javax.ejb.Stateless;

import modelo.Autor;
import modelo.Categoria;
import modelo.Editorial;
import modelo.Libro;
import java.util.ArrayList;

@Stateless
public class GestionLibros implements GestionLibrosRemote {

	private List<Libro> libros = new ArrayList<Libro>();
	
	public void guardarLibro(String codigo, String nombre, Autor autor, Categoria categoria, Editorial editorial){
		Libro l = new Libro();  
		l.setCodigo(codigo);  
		l.setTitulo(nombre);  
		l.setAutor(autor);
		l.setCategoria(categoria);
		l.setEditorial(editorial);
		System.out.println(l);
		libros.add(l);
	}
	
	public List<Libro> getLibros(){
		System.out.println(libros);
		return libros;
	}

	
}
