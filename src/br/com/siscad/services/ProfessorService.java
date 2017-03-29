package br.com.siscad.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.siscad.dao.ProfessorDAO;
import br.com.siscad.entities.Professor;

public class ProfessorService {
	static EntityManagerFactory fac  = Persistence.createEntityManagerFactory("siscad");
	
	public static void CadastraProfessor(Professor professor){

		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			ProfessorDAO dao = new ProfessorDAO(manager);
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
		EntityManager manager = fac.createEntityManager();
		manager.getTransaction().begin();
		try{
			ProfessorDAO dao = new ProfessorDAO(manager);
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
		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			ProfessorDAO dao = new ProfessorDAO(manager);
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
		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			ProfessorDAO dao = new ProfessorDAO(manager);
			dao.excluir(professor);
			manager.getTransaction().commit();
		}catch (Exception e){
			System.out.println("Ocorreu um erro durante a exclusão do professor!");
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
}