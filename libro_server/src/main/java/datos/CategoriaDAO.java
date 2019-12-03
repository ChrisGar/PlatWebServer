package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import modelo.Categoria;
import modelo.Libro;

@Stateless
public class CategoriaDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Categoria categoria)
	{
		em.persist(categoria);
		
	}
	
	public void update(Categoria categoria)
	{
		em.merge(categoria);
		
	}
	
	public void remove(int codigo)
	{
		Categoria categoria=this.read(codigo);
		em.remove(categoria);
		
	}
	
	public Categoria read(int codigo)
	{
		Categoria c=em.find(Categoria.class, codigo);
		return c;
	}
	
	
	//consulta a una BD, se hace refrencia a las entidades del paquete modelo, no a la BD
	public List<Categoria> getCategorias()
	{
		String jpql = "SELECT c FROM Categoria c";
		Query q = em.createQuery(jpql, Categoria.class);
		List<Categoria> categorias = q.getResultList();
		return categorias;
		
	}
	
	
	public List<Categoria> getCategoriasNombre(String filtro)
	{
		String jpql = "SELECT c FROM Categoria c WHERE nombre LIKE ?1 ";
		Query q = em.createQuery(jpql, Categoria.class);
		q.setParameter(1, "%"+filtro+"%");
		List<Categoria> categorias = q.getResultList();
		return categorias;
	}
	
	
	

}
