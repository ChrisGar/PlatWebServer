package negocio;

import java.util.List;


import javax.ejb.Stateless;
import modelo.Editorial;
import java.util.ArrayList;

@Stateless
public class GestionEditoriales implements GestionEditorialesRemote {

	private List<Editorial> editoriales = new ArrayList<Editorial>();
	
	public void guardarEditorial(String codigo, String nombre, String ciudad){
		Editorial e = new Editorial();  
		e.setCodigo(codigo);  
		e.setNombre(nombre); 
		e.setCiudad(ciudad);
		System.out.println(e);
		editoriales.add(e);
		System.out.print("Guardo Editorial");
	}
	
	public List<Editorial> getEditoriales(){
		System.out.println(editoriales);
		return editoriales;
	}




	
	
	
}
