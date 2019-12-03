package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Editorial implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4081883801015277020L;
	@Id
	private String codigo;
	private String nombre;
	private String ciudad;
	
	
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
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Editorial [codigo=" + codigo + ", nombre=" + nombre + ", ciudad=" + ciudad + "]";
	}
	
	
	
}
