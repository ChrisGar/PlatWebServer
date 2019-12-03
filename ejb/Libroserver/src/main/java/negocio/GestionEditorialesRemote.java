package negocio;

import java.util.List;


import javax.ejb.Remote;
import modelo.Editorial;

@Remote
public interface GestionEditorialesRemote {
	
	public void guardarEditorial(String codigo, String nombre, String ciudad);
	public List<Editorial> getEditoriales();

}

