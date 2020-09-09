package cl.toballatorre.simuno.modelos;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CIUDADES")
public class Ciudad {
	
	/******* ATRIBUTOS ******/
	@Id
	@Column(name="CIUDADID")
	private int id;
	private String nombreCiudad;
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ciudad")
	private Set<Beneficiario> listaBeneficiarios;
	
	/******* CONSTRUCTORES ******/
	public Ciudad() {
		
	}
	
	public Ciudad(int id, String nombreCiudad, Set<Beneficiario> listaBeneficiarios) {
		this.id = id;
		this.nombreCiudad = nombreCiudad;
		this.listaBeneficiarios = listaBeneficiarios;
	}

	/******* GETTERS AND SETTERS ******/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public Set<Beneficiario> getListaBeneficiarios() {
		return listaBeneficiarios;
	}

	public void setListaBeneficiarios(Set<Beneficiario> listaBeneficiarios) {
		this.listaBeneficiarios = listaBeneficiarios;
	}
	
}
