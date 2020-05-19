package br.com.munif.cursos.treinamento.entidades;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Entity
@Table(name = "cidade")
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class Cidade extends BaseEntity {
	
	private String nome;
	
	@ManyToOne
	private Estado estado;

	public Cidade() {
		super();
	}

	public Cidade(String nome, Estado estado) {
		super();
		this.nome = nome;
		this.setEstado(estado);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	

}
