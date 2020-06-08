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
	
	private Long populacao; 
	
	@ManyToOne
	private Pais pais;

	public Estado() {
		super();
		populacao=0l;
		
	}

	public Estado(String nome,Pais pais) {
		super();
		this.nome = nome;
		this.setPais(pais);
		this.populacao=0l;
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

	public Long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(Long populacao) {
		this.populacao = populacao;
	}
	
	
	
	
	

}
