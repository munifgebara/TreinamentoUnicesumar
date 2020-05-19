package br.com.munif.cursos.treinamento.repositorios;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import br.com.munif.cursos.treinamento.entidades.Cidade;



@Repository
public interface CidadeRepository  extends CrudRepository<Cidade,String>{
	
	

}