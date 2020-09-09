package cl.toballatorre.simuno.controladores;

import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import cl.toballatorre.simuno.modelos.Ayuda;
import cl.toballatorre.simuno.modelos.AyudasPorCiudad;
import cl.toballatorre.simuno.modelos.Beneficiario;
import cl.toballatorre.simuno.repositorios.AyudaRepository;
import cl.toballatorre.simuno.repositorios.AyudasPorCiudadRepository;
import cl.toballatorre.simuno.repositorios.BeneficiarioRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping(path = "/")
public class HomeController {

	@Autowired
	AyudasPorCiudadRepository ayudaPorCiudadRepository;
	@Autowired
	BeneficiarioRepository benefRepository;
	@Autowired
	AyudaRepository ayudaRepository;
	
    // Constantes
    // -----------------------------------------------------------------------------------------
	
	// Se define la URL del servicio REST
	private final String URL_BENEF = "http://localhost:8086/simuno/api/benef";

    /** Objeto {@link Logger} que contiene los métodos de depuración */
    private static final Logger logger = LogManager.getLogger(HomeController.class);

    // Solicitudes GET
    // -----------------------------------------------------------------------------------------

    /**
     * Muestra la Página de Inicio
     *
     * @param request objeto {@link HttpServletRequest} que contiene la información
     *                de la solicitud que le hace el cliente al {@link HttpServlet}
     * @param modelo  objeto {@link Model} con el modelo de la vista
     *
     * @return un objeto {@link String} con la respuesta a la solicitud
     */
    @GetMapping
    public String paginaInicio(HttpServletRequest request, Model modelo) {
        // Depuración
        logger.info("Solicitud GET: {}", request.getRequestURI());
        
        Set<AyudasPorCiudad> listaAyudasPorCiudades = ayudaPorCiudadRepository.getAyudasGroup();
        modelo.addAttribute("listaA", listaAyudasPorCiudades);
        
        //Se inicializa el RestTemplate para poder consumir el servicio
        RestTemplate restTemplate = new RestTemplate();
        // Se crea la respuesta para obtener un Array de tipo Beneficierio
        // Entregando la URL del servicio
        ResponseEntity<Beneficiario[]> responseBenef = restTemplate.getForEntity(URL_BENEF, Beneficiario[].class);
        // Se rescata de la respuesta el Array de los Beneficiarios
        Beneficiario[] listaBenef = responseBenef.getBody();
        // Se guarda la lista para enviar en conjunto con la respuesta
        modelo.addAttribute("listaBenef", listaBenef);
        
        // Se envía un objeto vacío de tipo Ayuda para recoger datos
        modelo.addAttribute("ayuda", new Ayuda());
        
        // Mostrar página
        return "home";
    }
    /**
     * 
     * @param request objeto {@link HttpServletRequest} que contiene la información
     *                de la solicitud que le hace el cliente al {@link HttpServlet}
     * @param modelo  objeto {@link Model} con el modelo de la vista
     * 
     * @param ayuda objeto devuelto por el requerimiento del cliente con datos ingresados
     * 				en sus atributos
     *
     * @return un objeto {@link String} con la respuesta a la solicitud
     */
    @PostMapping(path="/agregarAyuda")
    public String procesarFormularioAyuda(HttpServletRequest request, Model modelo, Ayuda ayuda) {
    	
    	logger.info("Solicitud GET: {}", request.getRequestURI());
    	
    	// se rescata la id del Beneficiario para completar los datos y persistir
    	// la ayuda en la base de datos
    	int id = Integer.parseInt(request.getParameter("idBenef"));
    	// Se obtiene la entidad del beneficiario con la id otenida
    	Optional<Beneficiario> b = benefRepository.findById(id);
    	
    	// se agrega el beneficiario encontrado por la id recogida del requerimiento
    	ayuda.setBeneficiario(b.get());
    	// se agrega la id única buscando el siguiente valor de la secuencia
    	ayuda.setId(ayudaRepository.getNextValSeq());
    	
    	ayudaRepository.save(ayuda);
    	
    	return "redirect: ./";
    }
    
    @GetMapping("/test")
    public String test() {
    	
    	System.out.println("getNextVal(): "+ayudaRepository.getNextVal());
    	System.out.println("----------------------------------------------");
    	System.out.println("getNextValSeq(): "+ayudaRepository.getNextValSeq());
    	
    	return "redirect: ./";
    }

}
