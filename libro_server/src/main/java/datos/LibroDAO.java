package datos;

import java.util.List;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import javax.persistence.Query;

import modelo.Libro;

@Stateless
public class LibroDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Libro libro)
	{
		em.persist(libro);
		
	}
	
	public void update(Libro libro)
	{
		em.merge(libro);
		
	}
	
	public void remove(String codigo)
	{
		Libro libro=this.read(codigo);
		em.remove(libro);
		
	}
	
	public Libro read(String codigo)
	{
		Libro l=em.find(Libro.class, codigo);
		return l;
	}
	
	
	//consulta a una BD, se hace refrencia a las entidades del paquete modelo, no a la BD
	public List<Libro> getLibros()
	{
		String jpql = "SELECT l FROM Libro l";
		Query q = em.createQuery(jpql, Libro.class);
		List<Libro> libros = q.getResultList();
		return libros;
		
	}
	
	
	public List<Libro> getLibrosNombre(String filtro)
	{
		String jpql = "SELECT l FROM Libro l WHERE titulo LIKE ?1 ";
		Query q = em.createQuery(jpql, Libro.class);
		q.setParameter(1, "%"+filtro+"%");
		List<Libro> libros = q.getResultList();
		return libros;
		
	}
	
	
	

}
