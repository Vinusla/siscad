package br.com.siscad.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.siscad.dao.TurmaDAO;
import br.com.siscad.entities.Turma;

public class TurmaService {
	static EntityManagerFactory fac  = Persistence.createEntityManagerFactory("siscad");
	
	public static void CadastrarTurma(Turma Turma){

		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			TurmaDAO dao = new TurmaDAO(manager);
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
		EntityManager manager = fac.createEntityManager();
		manager.getTransaction().begin();
		try{
			TurmaDAO dao = new TurmaDAO(manager);
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
		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			TurmaDAO dao = new TurmaDAO(manager);
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
		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			TurmaDAO dao = new TurmaDAO(manager);
			dao.excluir(Turma);
			manager.getTransaction().commit();
		}catch (Exception e){
			System.out.println("Turma não removida!");
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
}

