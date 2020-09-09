package cl.toballatorre.simuno.modelos;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="BENEFICIARIOS")
public class Beneficiario {

	/******* ATRIBUTOS ******/
	@Id
	@Column(name="BENEFICIARIOID")
	private int id;
	private String nombre;
	private int edad;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="CIUDADID")
	private Ciudad ciudad;
	@JsonIgnore
	@OneToMany(mappedBy = "beneficiario")
	private Set<Ayuda> listaAyudas;
	
	/******* CONSTRUCTORES ******/
	public Beneficiario() {
		
	}
	
	public Beneficiario(int id, String nombre, int edad, Ciudad ciudad, Set<Ayuda> listaAyudas) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.ciudad = ciudad;
		this.listaAyudas = listaAyudas;
	}

	/******* GETTERS AND SETTERS ******/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Set<Ayuda> getListaAyudas() {
		return listaAyudas;
	}

	public void setListaAyudas(Set<Ayuda> listaAyudas) {
		this.listaAyudas = listaAyudas;
	}
	
}
