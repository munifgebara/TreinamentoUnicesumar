package br.com.munif.cursos.treinamento.repositorios;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import br.com.munif.cursos.treinamento.entidades.Pais;



@Repository
public interface PaisRepository  extends CrudRepository<Pais,String>{
	
	

}