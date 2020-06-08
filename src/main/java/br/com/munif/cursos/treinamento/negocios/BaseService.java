package br.com.munif.cursos.treinamento.negocios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.munif.cursos.treinamento.entidades.BaseEntity;

public abstract class BaseService<T extends BaseEntity> {
	
	@Autowired
	protected JpaRepository<T, String> respositorio;

	public List<T> consultaTodos() {
		List<T> todas = respositorio.findAll();
		return todas;
	}

	public Optional<T> consultaPorId(String id) {
		return respositorio.findById(id);
	}

	public void apaga(T entidade) {
		respositorio.delete(entidade);
	}

	public T salva(T nova) {
		return respositorio.save(nova);
	}
	
	
	

}
