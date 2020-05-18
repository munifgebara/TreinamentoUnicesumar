package br.com.munif.cursos.treinamento.entidades;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "pais")
@Audited
public class Pais extends BaseEntity {
	
	private String nome;
	


	public Pais() {
		super();
	}
	

	public Pais(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
