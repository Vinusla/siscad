package br.com.siscad.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.siscad.dao.AlunoDAO;
import br.com.siscad.dao.ProfessorDAO;
import br.com.siscad.entities.Professor;

public class ProfessorService {
	
	public static void CadastraProfessorNoCurso(Professor professor){

		ProfessorDAO dao = new ProfessorDAO();
		EntityManager manager = dao.getEntityManger();
		
		try{
			manager.getTransaction().begin();			
			dao.inserir(professor);
			manager.getTransaction().commit();
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	
	public static Professor buscarProfessorPorId(Long id){
		Professor professor = null;
		ProfessorDAO dao = new ProfessorDAO();
		EntityManager manager = dao.getEntityManger();
		manager.getTransaction().begin();
		try{			
			professor = dao.buscarPorId(id);
		}catch (Exception e){
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			manager.close();
		}
		return professor;
	
	}
	
	public static void AlterarProfessor(Professor professor){
		ProfessorDAO dao = new ProfessorDAO();
		EntityManager manager = dao.getEntityManger();
		try{
			manager.getTransaction().begin();			
			dao.atualizar(professor);
			manager.getTransaction().commit();
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	public static void RemoverProfessor(Professor professor){
		ProfessorDAO dao = new ProfessorDAO();
		EntityManager manager = dao.getEntityManger();
		try{
			manager.getTransaction().begin();			
			dao.excluir(professor);
			manager.getTransaction().commit();
		}catch (Exception e){
			System.out.println("Ocorreu um erro durante a exclus�o do professor!");
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
}