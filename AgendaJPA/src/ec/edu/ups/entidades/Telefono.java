package ec.edu.ups.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Telefono
 *
 */
@Entity

public class Telefono implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String numero;
	private String tipo;
	private String operadora;
	@ManyToOne
	@JoinColumn
	private Usuario cedulaU;
	
	
	public Telefono() {
		
	}
	public Telefono(int codigo, String numero, String tipo, String operadora, Usuario cedulaU) {
		super();
		this.codigo=codigo;
		this.numero= numero;
		this.tipo=tipo;
		this.operadora=operadora;
		this.cedulaU = cedulaU;
	}
	
//Getters and Setters.
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getOperadora() {
		return operadora;
	}
	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	public Usuario getCedulaU() {
		return cedulaU;
	}
	public void setCedulaU(Usuario cedulaU) {
		this.cedulaU = cedulaU;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}
	
// hashCode & equals.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefono other = (Telefono) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
//toString.
	@Override
	public String toString() {
		return "Telefono [codigo=" + codigo + ", numero=" + numero + ", tipo=" + tipo + ", operadora=" + operadora
				+ ", cedulaU=" + cedulaU + "]";
	}
   
}
