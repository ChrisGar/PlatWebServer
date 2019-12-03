package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import modelo.Editorial;
import modelo.Libro;

@Stateless
public class EditorialDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Editorial editorial)
	{
		em.persist(editorial);
		
	}
	
	public void update(Editorial editorial)
	{
		em.merge(editorial);
		
	}
	
	public void remove(int codigo)
	{
		Editorial editorial=this.read(codigo);
		em.remove(editorial);
		
	}
	
	public Editorial read(int codigo)
	{
		Editorial e=em.find(Editorial.class, codigo);
		return e;
	}
	
	
	//consulta a una BD, se hace refrencia a las entidades del paquete modelo, no a la BD
	public List<Editorial> getEditoriales()
	{
		String jpql = "SELECT e FROM Editorial e";
		Query q = em.createQuery(jpql, Editorial.class);
		List<Editorial> editoriales = q.getResultList();
		return editoriales;
		
	}
	
	
	public List<Editorial> getEditorialesNombre(String filtro)
	{
		String jpql = "SELECT e FROM Editorial e WHERE nombre LIKE ?1 ";
		Query q = em.createQuery(jpql, Editorial.class);
		q.setParameter(1, "%"+filtro+"%");
		List<Editorial> editoriales = q.getResultList();
		return editoriales;
		
	}
	
	
	

}
