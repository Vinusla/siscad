package br.com.siscad.services;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.siscad.dao.AlunoDAO;
import br.com.siscad.entities.Aluno;


public class AlunoService {

	
	public static void matriculaAluno(Aluno aluno){
		AlunoDAO dao = new AlunoDAO();
		EntityManager manager = dao.getEntityManger();
		try{
			manager.getTransaction().begin();						
			dao.inserir(aluno);
			manager.getTransaction().commit();
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	public static void matriculaAlunoNoCurso(Aluno aluno){
		AlunoDAO dao = new AlunoDAO();
		EntityManager manager = dao.getEntityManger();
		try{
			manager.getTransaction().begin();						
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
		AlunoDAO dao = new AlunoDAO();
		EntityManager manager = dao.getEntityManger();
		manager.getTransaction().begin();
		try{	
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
	
	public static Aluno buscarAlunoPorLogin(String login){
		Aluno aluno = null;
		AlunoDAO dao = new AlunoDAO();
		EntityManager manager = dao.getEntityManger();
		manager.getTransaction().begin();
		try{		
			aluno = dao.buscarPorLogin(login);
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
		AlunoDAO dao = new AlunoDAO();
		EntityManager manager = dao.getEntityManger();
		try{
			manager.getTransaction().begin();			
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
		AlunoDAO dao = new AlunoDAO();
		EntityManager manager = dao.getEntityManger();
		try{
			manager.getTransaction().begin();			
			dao.excluir(aluno);
			manager.getTransaction().commit();
		}catch (Exception e){
			System.out.println("Ocorreu um erro durante a exclus�o do aluno!");
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	
	/*public static boolean getAlunoPorSituacao(Aluno aluno, Desempenho desempenho){
		EntityManager manager = fac.createEntityManager();
		List <Nota> notas = new ArrayList();
		
		try{
			manager.getTransaction().begin();
			AlunoDAO dao = new AlunoDAO(manager);
			
			if(aluno.getId() == desempenho.getAluno().getId())
			    notas =  
			
			
			manager.getTransaction().commit();
		}catch (Exception e){
			System.out.println("Ocorreu um erro durante a exclus�o do aluno!");
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
*/	
	
}
