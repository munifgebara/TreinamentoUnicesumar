package br.com.munif.cursos.treinamento.negocios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.munif.cursos.treinamento.entidades.Cidade;
import br.com.munif.cursos.treinamento.repositorios.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository respositorioCidade;

	public List<Cidade> consultaTodos() {
		List<Cidade> todas = respositorioCidade.findAll();
		return todas;
	}

	public Optional<Cidade> consultaPorId(String id) {
		return respositorioCidade.findById(id);
	}

	public void apaga(Cidade cidade) {
		respositorioCidade.delete(cidade);
	}

	public Cidade salva(Cidade nova) {
		return respositorioCidade.save(nova);
	}
	

	

}
