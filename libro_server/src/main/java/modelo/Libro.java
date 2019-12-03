package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Libro{
	
	/**
	 * 
	 */
	@Id
	@Column(name="codigo_libro")
	private String codigo;
	
	@Column(name="titulo_libro")
	private String titulo;

	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_libro")
	private List<Autor> autores;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_libro")
	private List<Categoria> categorias;
	
	private String editorial;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
	
	
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	public void addAutor(Autor autor)
	{
		if(autores==null)
			autores=new ArrayList<Autor>();
		autores.add(autor);

	}
	
	
	public void addCategoria(Categoria categoria)
	{
		if(categorias==null)
			categorias=new ArrayList<Categoria>();
		categorias.add(categoria);
	}
	
	
	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", titulo=" + titulo + ", autores=" + autores + ", categorias=" + categorias
				+ ", editorial=" + editorial + "]";
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
}
