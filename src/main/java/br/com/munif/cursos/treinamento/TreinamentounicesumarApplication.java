package br.com.munif.cursos.treinamento;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.munif.cursos.treinamento.entidades.Pais;
import br.com.munif.cursos.treinamento.repositorios.PaisRepository;

@SpringBootApplication
public class TreinamentounicesumarApplication {
	

	@Autowired
	private PaisRepository paisRepository;

	public static void main(String[] args) {
		SpringApplication.run(TreinamentounicesumarApplication.class, args);
	}

	
	
	@PostConstruct
	private void initDb() {
		Pais br=paisRepository.save(new Pais("Brasil"));
		Pais pr=paisRepository.save(new Pais("Paraguai"));
		
		
		
	}
	
}
