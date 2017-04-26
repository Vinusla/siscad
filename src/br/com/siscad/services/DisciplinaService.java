package br.com.siscad.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.siscad.dao.AlunoDAO;
import br.com.siscad.dao.DisciplinaDAO;
import br.com.siscad.entities.Disciplina;

public class DisciplinaService {
	
	
	public static void CadastrarDisciplina(Disciplina disciplina){

		DisciplinaDAO dao = new DisciplinaDAO();
		EntityManager manager = dao.getEntityManger();
		try{
			manager.getTransaction().begin();			
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
		DisciplinaDAO dao = new DisciplinaDAO();
		EntityManager manager = dao.getEntityManger();
		manager.getTransaction().begin();
		try{			
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
		DisciplinaDAO dao = new DisciplinaDAO();
		EntityManager manager = dao.getEntityManger();
		try{
			manager.getTransaction().begin();			
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
		DisciplinaDAO dao = new DisciplinaDAO();
		EntityManager manager = dao.getEntityManger();
		try{
			manager.getTransaction().begin();			
			dao.excluir(disciplina);
			manager.getTransaction().commit();
		}catch (Exception e){
			System.out.println("Ocorreu um erro durante a exclus�o da disciplina!");
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
}
