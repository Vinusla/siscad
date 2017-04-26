package br.com.siscad.dao;

import javax.persistence.EntityManager;

import br.com.siscad.entities.Curso;

public class CursoDAO extends AbstractDAO<Curso> {
	
	public CursoDAO(EntityManager entity) {
		super(entity);
	}
	
	public CursoDAO() {
		super();

	}

	@Override
	public Class<Curso> entityClass() {
		return Curso.class;
	}
	


}

