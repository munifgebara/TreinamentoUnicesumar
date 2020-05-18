package br.com.munif.cursos.treinamento;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.munif.cursos.treinamento.entidades.Estado;
import br.com.munif.cursos.treinamento.entidades.Pais;
import br.com.munif.cursos.treinamento.repositorios.EstadoRepository;
import br.com.munif.cursos.treinamento.repositorios.PaisRepository;

@SpringBootApplication
public class TreinamentounicesumarApplication {
	

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(TreinamentounicesumarApplication.class, args);
	}

	
	
	@PostConstruct
	private void initDb() {
		Pais br=paisRepository.save(new Pais("Brasil"));
		Pais pr=paisRepository.save(new Pais("Paraguai"));
		
		estadoRepository.save(new Estado("Paraná", br));
		estadoRepository.save(new Estado("São Paulo", br));
		
		estadoRepository.save(new Estado("Amambai", pr));
		
		
		
	}
	
}
