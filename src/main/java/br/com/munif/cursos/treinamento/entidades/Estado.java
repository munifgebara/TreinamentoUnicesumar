package br.com.munif.cursos.treinamento.entidades;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

@Entity
@Table(name = "estado")
@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
public class Estado extends BaseEntity {
	
	private String nome;
	
	@ManyToOne
	private Pais pais;

	public Estado() {
		super();
	}

	public Estado(String nome,Pais pais) {
		super();
		this.nome = nome;
		this.setPais(pais);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
	

}
