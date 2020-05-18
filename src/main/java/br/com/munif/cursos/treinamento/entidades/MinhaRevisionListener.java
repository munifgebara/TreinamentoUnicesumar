package br.com.munif.cursos.treinamento.entidades;

import org.hibernate.envers.RevisionListener;

public class MinhaRevisionListener implements RevisionListener {

	@Override
	public void newRevision(Object revisionEntity) {
		MinhaRevisionEntity m=(MinhaRevisionEntity) revisionEntity;
		m.setIp("127.0.0.1");
		m.setUser("User");
		
	}

}
