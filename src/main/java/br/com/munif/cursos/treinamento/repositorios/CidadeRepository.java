package br.com.munif.cursos.treinamento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import br.com.munif.cursos.treinamento.entidades.Cidade;



@Repository
public interface CidadeRepository  extends JpaRepository<Cidade,String>{
	
	

}