package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import modelo.Autor;
import modelo.Libro;

@Stateless
public class AutorDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Autor autor)
	{
		em.persist(autor);
		
	}
	
	public void update(Autor autor)
	{
		em.merge(autor);
		
	}
	
	public void remove(int codigo)
	{
		Autor autor=this.read(codigo);
		em.remove(autor);
		
	}
	
	public Autor read(int codigo)
	{
		Autor a=em.find(Autor.class,codigo);
		return a;
	}
	
	
	//consulta a una BD, se hace refrencia a las entidades del paquete modelo, no a la BD
	public List<Autor> getAutores()
	{
		String jpql = "SELECT a FROM Autor a";
		Query q = em.createQuery(jpql, Autor.class);
		List<Autor> autores = q.getResultList();
		return autores;
		
	}
	
	
	public List<Autor> getAutoresNombre(String filtro)
	{
		String jpql = "SELECT l FROM Autor a WHERE nombre LIKE ?1 ";
		Query q = em.createQuery(jpql, Autor.class);
		q.setParameter(1, "%"+filtro+"%");
		List<Autor> autores = q.getResultList();
		return autores;
		
	}
	
	
	

}
