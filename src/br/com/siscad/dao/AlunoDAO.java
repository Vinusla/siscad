package br.com.siscad.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Criteria;

import br.com.siscad.entities.Aluno;

public class AlunoDAO extends AbstractDAO<Aluno> {

	public AlunoDAO(EntityManager entity) {
		super(entity);
	}
	
	public AlunoDAO() {
		super();
	}


	@Override
	public Class<Aluno> entityClass() {
		return Aluno.class;
	}
	
	public Aluno buscarPorLogin(String login){
		Aluno aluno = null;
		try{
			Query query=manager.createQuery("SELECT id FROM Aluno WHERE login='"+login+"'");
			Long id=(long) query.getSingleResult();
			aluno=buscarPorId(id);
		}catch (Exception e){

		}
		
		return aluno;
	}

}
