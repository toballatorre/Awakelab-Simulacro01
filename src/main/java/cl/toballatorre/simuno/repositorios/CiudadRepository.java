package cl.toballatorre.simuno.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.toballatorre.simuno.modelos.Ciudad;

@Repository
public interface CiudadRepository extends CrudRepository<Ciudad, Integer>{
	
}
