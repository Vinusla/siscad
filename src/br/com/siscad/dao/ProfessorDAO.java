package br.com.siscad.dao;

import javax.persistence.EntityManager;

import br.com.siscad.entities.Professor;

public class ProfessorDAO extends AbstractDAO<Professor> {

	public ProfessorDAO(EntityManager entity) {
		super(entity);
	}

	@Override
	public Class<Professor> entityClass() {
		return Professor.class;
	}
}
