package br.com.siscad.dao;

import javax.persistence.EntityManager;

import br.com.siscad.entities.Nota;

public class NotaDAO extends AbstractDAO<Nota>{

	public NotaDAO(EntityManager entity) {
		super(entity);
	}

	@Override
	public Class<Nota> entityClass() {
		return Nota.class;
	}
		
}
