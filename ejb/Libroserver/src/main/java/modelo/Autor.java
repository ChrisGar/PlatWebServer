package modelo;

import java.io.Serializable;

public class Autor implements Serializable {
	
	/**
	 * 
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4997310499552511028L;
	/**
	 * 
	 */
	
	private String codigo;
	private String nombre;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Autor [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	
	
	
	
}
