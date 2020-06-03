package br.com.munif.cursos.treinamento.api;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.munif.cursos.treinamento.entidades.Cidade;
import br.com.munif.cursos.treinamento.entidades.Estado;
import br.com.munif.cursos.treinamento.entidades.Pais;
import br.com.munif.cursos.treinamento.negocios.CidadeService;
import br.com.munif.cursos.treinamento.repositorios.CidadeRepository;
@RestController
@RequestMapping("/api/cidades")
public class CidadeApi {
	
	/// API <-------> SERVICE <------> REPOSITORY <---------> BANCO
	/// API <------- HORRIVEL -------> REPOSITORY <---------> BANCO

	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping
	public List<Cidade> consultaTodos(){
		return cidadeService.consultaTodos();
	}

	@GetMapping(value = "/{id}")
    public ResponseEntity<Cidade> consultaUm(@PathVariable  String id) {
		Optional<Cidade> cid=cidadeService.consultaPorId(id);
		if (cid.isPresent()) {
		   return  ResponseEntity.ok(cid.get());
		}
		return ResponseEntity.notFound().build();
    }
	
	@DeleteMapping(value = "/{id}")
    public ResponseEntity<Cidade> apagaUm(@PathVariable  String id) {
		Optional<Cidade> cid=cidadeService.consultaPorId(id);
		if (!cid.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		cidadeService.apaga(cid.get());
		return  ResponseEntity.ok(cid.get());
    }
	
    @PostMapping
    public ResponseEntity<Cidade> novo(@RequestBody Cidade nova) {
    	Cidade cidadeSalva= cidadeService.salva(nova);
        return new ResponseEntity <>(cidadeSalva, HttpStatus.CREATED);
    }
	
    @PutMapping(value = "/{id}")
    public ResponseEntity<Cidade> alterar(@PathVariable("id") String id, @RequestBody Cidade novoValorCidade) {
		Optional<Cidade> valorVelhoDeCidade=cidadeService.consultaPorId(id);
		if (!valorVelhoDeCidade.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		novoValorCidade.setId(id);
		novoValorCidade.setCd(valorVelhoDeCidade.get().getCd());
		novoValorCidade.setUd(new Date());
      	Cidade cidadeSalva= cidadeService.salva(novoValorCidade);
        return new ResponseEntity <>(cidadeSalva, HttpStatus.OK);
    }
	
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Cidade> alterarAlguns(@PathVariable("id") String id, @RequestBody Cidade novoValorCidade) {
		Optional<Cidade> valorVelhoDeCidade=cidadeService.consultaPorId(id);
   	    if (!valorVelhoDeCidade.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Cidade velhoValorCidade=valorVelhoDeCidade.get();

		// Vai ser usado um código genérico	
		if (novoValorCidade.getNome()!=null) {
			velhoValorCidade.setNome(novoValorCidade.getNome());
		}
		if (novoValorCidade.getEstado()!=null) {
			velhoValorCidade.setEstado(novoValorCidade.getEstado());
		}
		if (novoValorCidade.getPopulacao()!=null) {
			velhoValorCidade.setPopulacao(novoValorCidade.getPopulacao());
		}
		// Vai ser usado um código genérico		
		
		velhoValorCidade.setUd(new Date());
        Cidade cidadeSalva= cidadeService.salva(velhoValorCidade);
        return new ResponseEntity <>(cidadeSalva, HttpStatus.OK);
    }
	
}

