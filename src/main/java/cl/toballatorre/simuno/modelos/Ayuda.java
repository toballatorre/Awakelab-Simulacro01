package cl.toballatorre.simuno.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * Entidad para conectarse a la table AYUDAS de la base de datos
 * @author Cristobal L
 *
 */
@Entity
@Table(name="AYUDAS")
public class Ayuda {
	
	/******* ATRIBUTOS ******/
	@Id
	@Column(name="AYUDAID")
	private int id;
	private double monto;
	private String motivo;
	//Relación many to one según el modelo, EAGER para traer todos los datos
	@ManyToOne(fetch = FetchType.EAGER)
	//Se coloca el nombre de la columna del modelo para hacer las relaciones
	@JoinColumn(name = "BENEFICIARIOID")
	private Beneficiario beneficiario;
	
	/******* CONSTRUCTORES ******/
	public Ayuda() {
		
	}
	
	public Ayuda(int id, double monto, String motivo, Beneficiario beneficiario) {
		this.id = id;
		this.monto = monto;
		this.motivo = motivo;
		this.beneficiario = beneficiario;
	}

	/******* GETTERS AND SETTERS ******/
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public double getMonto() {
		return monto;
	}



	public void setMonto(double monto) {
		this.monto = monto;
	}



	public String getMotivo() {
		return motivo;
	}



	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}



	public Beneficiario getBeneficiario() {
		return beneficiario;
	}



	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}
	
	
}
