package br.com.siscad.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.siscad.dao.DisciplinaDAO;
import br.com.siscad.entities.Disciplina;

public class DisciplinaService {
	static EntityManagerFactory fac  = Persistence.createEntityManagerFactory("siscad");
	
	public static void CadastrarDisciplina(Disciplina disciplina){

		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			DisciplinaDAO dao = new DisciplinaDAO(manager);
			dao.inserir(disciplina);
			manager.getTransaction().commit();
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	
	public static Disciplina buscarDisciplinaPorId(Long id){
		Disciplina disciplina = null;
		EntityManager manager = fac.createEntityManager();
		manager.getTransaction().begin();
		try{
			DisciplinaDAO dao = new DisciplinaDAO(manager);
			disciplina = dao.buscarPorId(id);
		}catch (Exception e){
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			manager.close();
		}
		return disciplina;
	
	}
	
	public static void AlterarDisciplina(Disciplina disciplina){
		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			DisciplinaDAO dao = new DisciplinaDAO(manager);
			dao.atualizar(disciplina);
			manager.getTransaction().commit();
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	public static void RemoverDisciplina(Disciplina disciplina){
		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			DisciplinaDAO dao = new DisciplinaDAO(manager);
			dao.excluir(disciplina);
			manager.getTransaction().commit();
		}catch (Exception e){
			System.out.println("Ocorreu um erro durante a exclusão da disciplina!");
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
}
