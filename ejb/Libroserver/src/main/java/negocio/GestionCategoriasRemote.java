package negocio;

import java.util.List;


import javax.ejb.Remote;
import modelo.Categoria;

@Remote
public interface GestionCategoriasRemote {
	
	public void guardarCategoria(String codigo, String nombre);
	public List<Categoria> getCategorias();

}
