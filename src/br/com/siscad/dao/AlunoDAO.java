package br.com.siscad.dao;

import javax.persistence.EntityManager;

import br.com.siscad.entities.Aluno;

public class AlunoDAO extends AbstractDAO<Aluno> {

	public AlunoDAO(EntityManager entity) {
		super(entity);
	}

	@Override
	public Class<Aluno> entityClass() {
		return Aluno.class;
	}
	


}
