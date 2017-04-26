package br.com.siscad.dao;

import javax.persistence.EntityManager;

import br.com.siscad.entities.Turma;

public class TurmaDAO extends AbstractDAO<Turma> {
	
	public TurmaDAO(EntityManager entity) {
		super(entity);
	}
	
	public TurmaDAO(){
		super();
	}

	@Override
	public Class<Turma> entityClass() {
		return Turma.class;
	}
	


}
