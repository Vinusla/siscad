package br.com.siscad.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.siscad.dao.NotaDAO;
import br.com.siscad.entities.Nota;

public class NotaService {
	static EntityManagerFactory fac  = Persistence.createEntityManagerFactory("siscad");
	
	public static void AdicionaNota(Nota nota){

		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			NotaDAO dao = new NotaDAO(manager);
			dao.inserir(nota);
			manager.getTransaction().commit();
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	/*
	public static Professor buscarNotaPorId(Long id){
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
	
	}*/
	
	public static void AlterarNota(Nota nota){
		EntityManager manager = fac.createEntityManager();
		try{                                                             
			manager.getTransaction().begin();
			NotaDAO dao = new NotaDAO(manager);
			dao.atualizar(nota);
			manager.getTransaction().commit();
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	public static void RemoverNota(Nota nota){
		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			NotaDAO dao = new NotaDAO(manager);
			dao.excluir(nota);
			manager.getTransaction().commit();
		}catch (Exception e){
			System.out.println("Ocorreu um erro durante a exclusão da nota!");
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
}