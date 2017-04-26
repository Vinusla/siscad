package br.com.siscad.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.siscad.dao.AlunoDAO;
import br.com.siscad.dao.TurmaDAO;
import br.com.siscad.entities.Aluno;
import br.com.siscad.entities.Turma;

public class TurmaService {

	
	public static void CadastrarTurma(Turma Turma){

		TurmaDAO dao = new TurmaDAO();
		EntityManager manager = dao.getEntityManger();
		
		try{
			manager.getTransaction().begin();			
			dao.inserir(Turma);
			manager.getTransaction().commit();
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	
	public static Turma buscarTurma(Long id){
		Turma Turma = null;
		TurmaDAO dao = new TurmaDAO();
		EntityManager manager = dao.getEntityManger();
		manager.getTransaction().begin();
		try{			
			Turma = dao.buscarPorId(id);
		}catch (Exception e){
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			manager.close();
		}
		return Turma;
	
	}
	
	public static void AlterarTurma(Turma Turma){
		TurmaDAO dao = new TurmaDAO();
		EntityManager manager = dao.getEntityManger();
		try{
			manager.getTransaction().begin();			
			dao.atualizar(Turma);
			manager.getTransaction().commit();
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	public static void RemoverTurma(Turma Turma){
		TurmaDAO dao = new TurmaDAO();
		EntityManager manager = dao.getEntityManger();
		try{
			manager.getTransaction().begin();		
			dao.excluir(Turma);
			manager.getTransaction().commit();
		}catch (Exception e){
			System.out.println("Turma n�o removida!");
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	
	public static void MatricularAluno(Aluno aluno, Turma Turma){
		TurmaDAO dao = new TurmaDAO();
		EntityManager manager = dao.getEntityManger();
		
	
	}
	
	
}

