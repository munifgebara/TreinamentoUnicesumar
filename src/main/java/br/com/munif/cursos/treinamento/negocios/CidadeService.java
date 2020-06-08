package br.com.munif.cursos.treinamento.negocios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.munif.cursos.treinamento.entidades.Cidade;
import br.com.munif.cursos.treinamento.entidades.Estado;
import br.com.munif.cursos.treinamento.repositorios.CidadeRepository;
import br.com.munif.cursos.treinamento.repositorios.EstadoRepository;

@Service
public class CidadeService extends BaseService<Cidade>{
	
	@Autowired
	private EstadoRepository estadoRepository; // Mudar para Service

	@Override
	public Cidade salva(Cidade nova) {
		long populacaoAntiga=0l;
		if (nova.getId()!=null) {
	     Optional<Cidade> resposta= respositorio.findById(nova.getId());
	     if (resposta.isPresent()) {
	     populacaoAntiga=resposta.get().getPopulacao();
	     }
		}
		Estado estado=estadoRepository.findById(nova.getEstado().getId()).get(); // Garantir que estado não é nulo
		long novaPopulacao=estado.getPopulacao()+nova.getPopulacao()-populacaoAntiga;
		estado.setPopulacao(novaPopulacao);
		estadoRepository.save(estado);
		return super.salva(nova);
	}

	@Override
	public void apaga(Cidade entidade) {
		Estado estado=estadoRepository.findById(entidade.getEstado().getId()).get(); // Garantir que estado não é nulo
		long novaPopulacao=estado.getPopulacao()-entidade.getPopulacao();
		estado.setPopulacao(novaPopulacao);
		estadoRepository.save(estado);
		super.apaga(entidade);
	}
	
	

}
