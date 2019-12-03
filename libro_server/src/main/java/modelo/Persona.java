package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Persona implements Serializable{
	
	
	/**
	 * 
	 */
	

	@Id
	@Column(name="per_cedula")
	private String cedula;
	
	@Column(name="per_nombre")
	private String nombre;
	
	@Column(name="per_direccion")
	private String direccion;
	
	@OneToMany(cascade = CascadeType.ALL) //para actualizar, eliminar tanto el padre como el hijo
	@JoinColumn(name="per_cedula")
	private List<Telefono> telefonos;
	
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<Telefono> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	
	
}
