package br.com.siscad.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


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
	
	/*public Aluno buscarPorLogin(String login){
		Aluno aluno = null;
		try{
			Query query=manager.createQuery("SELECT id FROM Aluno WHERE login='"+login+"'");
			Long id=(long) query.getSingleResult();
			aluno=buscarPorId(id);
		}catch (Exception e){

		}
		
		return aluno;
	}*/
	
	public Aluno efetuaLogin(String login, String senha){		
		Query query = this.getEntityManger().createQuery("select a from Aluno a where a.login = :login and a.senha = :senha");		
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		List<Aluno> alunos = query.getResultList();
		if(!alunos.isEmpty()){	
			
			return alunos.get(0);
		}
		
		return null;
		
	}
	
	

}
