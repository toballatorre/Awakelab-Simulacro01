package cl.toballatorre.simuno.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cl.toballatorre.simuno.modelos.Ayuda;

public interface AyudaRepository extends CrudRepository<Ayuda, Integer> {
	
	@Query(value = "SELECT AYUDAS_SEQ.nextval FROM dual", nativeQuery = true)
	public int getNextValSeq();
	
	@Query(value = "SELECT ayudaid+1 as id FROM ayudas WHERE ayudaid = (SELECT MAX(ayudaid) FROM ayudas)", nativeQuery = true)
	public int getNextVal();

}
