package cl.toballatorre.simuno.modelos;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Entidad creada para traer la agrupación de las ayudas sumando sus montos
 * agrupados por ciudad y tipo de ayudas en orden acendente por ciudad
 * @author Cristobal L
 *
 */
@Entity
public class AyudasPorCiudad {
	
	@Id
	private long id;
	private String ciudad;
	private String tipoAyuda;
	private double monto;
	
	public AyudasPorCiudad() {
		
	}
	
	public AyudasPorCiudad(long id, String ciudad, String tipoAyuda, double monto) {
		this.id = id;
		this.ciudad = ciudad;
		this.tipoAyuda = tipoAyuda;
		this.monto = monto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTipoAyuda() {
		return tipoAyuda;
	}

	public void setTipoAyuda(String tipoAyuda) {
		this.tipoAyuda = tipoAyuda;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
}
