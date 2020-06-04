package br.com.munif.cursos.treinamento.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.munif.cursos.treinamento.entidades.Estado;


@Repository
public interface EstadoRepository  extends JpaRepository<Estado,String>{
	
	

}