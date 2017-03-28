package br.com.siscad.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.siscad.dao.AlunoDAO;
import br.com.siscad.entities.Aluno;

public class AlunoService {
	static EntityManagerFactory fac  = Persistence.createEntityManagerFactory("siscad");
	
	public static void MatriculaAluno(Aluno aluno){

		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			AlunoDAO dao = new AlunoDAO(manager);
			dao.inserir(aluno);
			manager.getTransaction().commit();
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	
	public static Aluno buscarAlunoPorId(Long id){
		Aluno aluno = null;
		EntityManager manager = fac.createEntityManager();
		manager.getTransaction().begin();
		try{
			AlunoDAO dao = new AlunoDAO(manager);
			aluno = dao.buscarPorId(id);
		}catch (Exception e){
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			manager.close();
		}
		return aluno;
	
	}
	
	public static void AlterarAluno(Aluno aluno){
		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			AlunoDAO dao = new AlunoDAO(manager);
			dao.atualizar(aluno);
			manager.getTransaction().commit();
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	public static void RemoverAluno(Aluno aluno){
		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			AlunoDAO dao = new AlunoDAO(manager);
			dao.excluir(aluno);
			manager.getTransaction().commit();
		}catch (Exception e){
			System.out.println("Aluno removido com erro!");
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
}
