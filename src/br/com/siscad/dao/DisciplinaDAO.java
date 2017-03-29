package br.com.siscad.dao;

import javax.persistence.EntityManager;

import br.com.siscad.entities.Disciplina;

public class DisciplinaDAO  extends AbstractDAO<Disciplina> {

	public DisciplinaDAO(EntityManager entity) {
		super(entity);
	}

	@Override
	public Class<Disciplina> entityClass() {
		return Disciplina.class;
	}
	
}
