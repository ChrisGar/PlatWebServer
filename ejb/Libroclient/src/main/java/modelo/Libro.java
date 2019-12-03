package modelo;

import java.io.Serializable;

public class Libro implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -20336965027624681L;
	private String codigo;
	private String titulo;
	private Autor autor;
	private Categoria categoria;
	private Editorial editorial;
	
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
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", titulo=" + titulo + ", autor=" + autor + ", categoria=" + categoria
				+ ", editorial=" + editorial + "]";
	}
	
	
	
	
}
