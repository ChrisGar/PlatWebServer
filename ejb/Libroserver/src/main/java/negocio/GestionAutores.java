package negocio;

import java.util.List;


import javax.ejb.Stateless;

import modelo.Autor;
import java.util.ArrayList;

@Stateless
public class GestionAutores implements GestionAutoresRemote {

	private List<Autor> autores = new ArrayList<Autor>();
	
	public void guardarAutor(String codigo, String nombre){
		Autor a = new Autor();  
		a.setCodigo(codigo);  
		a.setNombre(nombre); 
		System.out.println(a);
		autores.add(a);
	}
	
	public List<Autor> getAutores(){
		System.out.println(autores);
		return autores;
	}

	
	
	
}
