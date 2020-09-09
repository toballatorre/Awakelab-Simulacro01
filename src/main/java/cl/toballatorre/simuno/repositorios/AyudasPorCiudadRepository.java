package cl.toballatorre.simuno.repositorios;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.toballatorre.simuno.modelos.AyudasPorCiudad;

@Repository
public interface AyudasPorCiudadRepository extends CrudRepository<AyudasPorCiudad, Integer>{
	
	// Query SQL oracle 11g para agrupar los resultados sumando los montos
	// Se usa ROW_NUMBER para generar una id de cada fila ya que no existe la entidad
	@Query(value = "SELECT ROW_NUMBER() OVER (ORDER BY ciudades.nombreciudad, ayudas.motivo desc) as id, \r\n" + 
			"    ciudades.nombreciudad as ciudad, ayudas.motivo as tipoayuda, SUM(ayudas.monto) as monto FROM ayudas\r\n" + 
			"    INNER JOIN beneficiarios\r\n" + 
			"    ON beneficiarios.beneficiarioid = ayudas.beneficiarioid\r\n" + 
			"    INNER JOIN ciudades\r\n" + 
			"    ON ciudades.ciudadid = beneficiarios.ciudadid\r\n" + 
			"    GROUP BY ciudades.nombreciudad, ayudas.motivo\r\n" + 
			"    ORDER BY ciudades.nombreciudad", nativeQuery = true)
	public Set<AyudasPorCiudad> getAyudasGroup();
}
