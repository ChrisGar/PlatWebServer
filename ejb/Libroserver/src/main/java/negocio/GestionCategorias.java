package negocio;

import java.util.List;


import javax.ejb.Stateless;

import modelo.Categoria;
import java.util.ArrayList;

@Stateless
public class GestionCategorias implements GestionCategoriasRemote {

	private List<Categoria> categorias = new ArrayList<Categoria>();
	
	public void guardarCategoria(String codigo, String nombre){
		Categoria c = new Categoria();  
		c.setCodigo(codigo);  
		c.setNombre(nombre); 
		System.out.println(c);
		categorias.add(c);
		System.out.print("Guardo Categoria");
	}
	
	public List<Categoria> getCategorias(){
		System.out.println(categorias);
		return categorias;
	}


	
}
