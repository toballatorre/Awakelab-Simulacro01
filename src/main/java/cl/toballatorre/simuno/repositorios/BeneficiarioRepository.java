package cl.toballatorre.simuno.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.toballatorre.simuno.modelos.Beneficiario;

@Repository
public interface BeneficiarioRepository extends CrudRepository<Beneficiario, Integer>{

}
