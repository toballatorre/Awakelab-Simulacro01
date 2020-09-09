package cl.toballatorre.simuno.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.toballatorre.simuno.modelos.Beneficiario;
import cl.toballatorre.simuno.repositorios.BeneficiarioRepository;

//Se define como un controlador REST
@RestController
//Se define el path para poder llamar y el media type como JSON
@RequestMapping(path = "/api/benef", produces = MediaType.APPLICATION_JSON_VALUE)
public class BeneficiarioRest {

	@Autowired
	BeneficiarioRepository br;
	
	/*
	 * Servicio rest que envía un Array de Beneficiarios para ser consumido
	 */
	@GetMapping
	public List<Beneficiario> listaBenef(){
		
		Optional<List<Beneficiario>> listaBenef = Optional.of((List<Beneficiario>) br.findAll());
		
		if (listaBenef.isPresent()) {
			return listaBenef.get();
		}else
			return null;
	}
}
