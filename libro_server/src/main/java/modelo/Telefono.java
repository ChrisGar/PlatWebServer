package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Telefono implements Serializable{
	
	
	/**
	 * 
	 */
	
	@Id
	@Column(name="tel_codigo")
	private String codigo;
	
	@Column(name="tel_num")
	private String numero;
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "Telefono [codigo=" + codigo + ", numero=" + numero + "]";
	}
	
	
	
		
}
