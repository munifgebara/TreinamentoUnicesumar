package br.com.munif.cursos.treinamento.api;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.munif.cursos.treinamento.entidades.Cidade;
import br.com.munif.cursos.treinamento.entidades.Estado;
import br.com.munif.cursos.treinamento.entidades.Pais;
import br.com.munif.cursos.treinamento.repositorios.CidadeRepository;

@RestController
@RequestMapping("/api/cidades")
public class CidadeApi {
	
	/// API <-------> SERVICE <------> REPOSITORY <---------> BANCO
	/// API <------- HORRIVEL -------> REPOSITORY <---------> BANCO
	
	@Autowired
	private CidadeRepository respositorioCidade;
	
	
	
	@GetMapping
	public List<Cidade> consultaTodos(){
		List<Cidade> todas = respositorioCidade.findAll();
		return todas;
	}

	@GetMapping(value = "/{id}")
    public ResponseEntity<Cidade> consultaUm(@PathVariable  String id) {
		Optional<Cidade> cid=respositorioCidade.findById(id);
		if (cid.isPresent()) {
		   return  ResponseEntity.ok(cid.get());
		}
		return ResponseEntity.notFound().build();
    }
	
	
}
