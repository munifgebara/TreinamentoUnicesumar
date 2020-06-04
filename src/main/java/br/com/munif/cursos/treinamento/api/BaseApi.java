package br.com.munif.cursos.treinamento.api;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.munif.cursos.treinamento.entidades.BaseEntity;
import br.com.munif.cursos.treinamento.negocios.BaseService;
@RestController
@Scope("prototype")
public class BaseApi <T extends BaseEntity> {
	
	/// <--MODEL ou TO--> API <-MODEL-> SERVICE <-MODEL-> REPOSITORY (MODEL DO MVC1) <---------> BANCO
	/// API <------- HORRIVEL -------> REPOSITORY <---------> BANCO

	@Autowired
	private BaseService<T> service;
	
	@GetMapping
	public List<T> consultaTodos(){
		return service.consultaTodos();
	}

	@GetMapping(value = "/{id}")
    public ResponseEntity<T> consultaUm(@PathVariable  String id) {
		Optional<T> obj=service.consultaPorId(id);
		if (obj.isPresent()) {
		   return  ResponseEntity.ok(obj.get());
		}
		return ResponseEntity.notFound().build();
    }
	
	@DeleteMapping(value = "/{id}")
    public ResponseEntity<T> apagaUm(@PathVariable  String id) {
		Optional<T> obj=service.consultaPorId(id);
		if (!obj.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		service.apaga(obj.get());
		return  ResponseEntity.ok(obj.get());
    }
	
    @PostMapping
    public ResponseEntity<T> novo(@RequestBody T nova) {
    	T entidadeSalva= service.salva(nova);
        return new ResponseEntity <>(entidadeSalva, HttpStatus.CREATED);
    }
	
    @PutMapping(value = "/{id}")
    public ResponseEntity<T> alterar(@PathVariable("id") String id, @RequestBody T novoValor) {
		Optional<T> valorVelho=service.consultaPorId(id);
		if (!valorVelho.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		novoValor.setId(id);
		novoValor.setCd(valorVelho.get().getCd());
		novoValor.setUd(new Date());
      	T entidadeSalva= service.salva(novoValor);
        return new ResponseEntity <>(entidadeSalva, HttpStatus.OK);
    }
	
    //TODO ARRUMAR O MÈTODO
    @PatchMapping(value = "/{id}")
    public ResponseEntity<T> alterarAlguns(@PathVariable("id") String id, @RequestBody T novoValor) {
		Optional<T> valorVelhode=service.consultaPorId(id);
   	    if (!valorVelhode.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		T velhoValor=valorVelhode.get();

		// Vai ser usado um código genérico	
//		if (novoValor.getNome()!=null) {
//			velhoValor.setNome(novoValor.getNome());
//		}
//		if (novoValor.getEstado()!=null) {
//			velhoValor.setEstado(novoValor.getEstado());
//		}
//		if (novoValor.getPopulacao()!=null) {
//			velhoValor.setPopulacao(novoValor.getPopulacao());
//		}
		// Vai ser usado um código genérico		
		
		novoValor.setUd(new Date());
        T entidadeSalva= service.salva(novoValor);
        return new ResponseEntity <>(entidadeSalva, HttpStatus.OK);
    }
	
}

