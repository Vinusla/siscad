package br.com.siscad.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.siscad.entities.Professor;

public class ProfessorDAO extends AbstractDAO<Professor> {

	public ProfessorDAO(EntityManager entity) {
		super(entity);
	}
	
	public ProfessorDAO() {
		super();
	
	}

	@Override
	public Class<Professor> entityClass() {
		return Professor.class;
	}
	
	
	public Professor efetuaLogin(String login, String senha){
		Query query = this.getEntityManger().createQuery("select p from Professor p where p.login = :login and p.senha = :senha");
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		List<Professor> professores = query.getResultList();
		if(!professores.isEmpty()){
			return professores.get(0);
		}
		return null;
		
	}
}
