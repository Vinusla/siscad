package br.com.siscad.services;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mchange.v2.resourcepool.ResourcePool.Manager;

import br.com.siscad.dao.CursoDAO;
import br.com.siscad.entities.Curso;
import br.com.siscad.entities.Professor;
import br.com.siscad.entities.Disciplina;;


public class CursoService {
	static EntityManagerFactory fac  = Persistence.createEntityManagerFactory("siscad");
	
	public static void CadastrarCurso(Curso curso){

		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			CursoDAO dao = new CursoDAO(manager);
			dao.inserir(curso);
			manager.getTransaction().commit();
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	
	public static Curso buscarCurso(Long id){
		Curso curso = null;
		EntityManager manager = fac.createEntityManager();
		manager.getTransaction().begin();
		try{
			CursoDAO dao = new CursoDAO(manager);
			curso = dao.buscarPorId(id);
		}catch (Exception e){
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			manager.close();
		}
		return curso;
	
	}
	
	public static void AlterarCurso(Curso curso){
		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			CursoDAO dao = new CursoDAO(manager);
			dao.atualizar(curso);
			manager.getTransaction().commit();
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	public static void RemoverCurso(Curso curso){
		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			CursoDAO dao = new CursoDAO(manager);
			dao.excluir(curso);
			manager.getTransaction().commit();
		}catch (Exception e){
			System.out.println("Curso não removido!");
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	public static void inserirProfessorCurso(Professor professor,Curso curso){
		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			CursoDAO dao = new CursoDAO(manager);
			curso.setProfessores(new ArrayList<>());
			curso.getProfessores().add(professor);
			
			professor.setCursos(new ArrayList<>());
			professor.getCursos().add(curso);
			dao.atualizar(curso);			
			manager.getTransaction().commit();
		}catch (Exception e){
			System.out.println("professor não pode ser inserido no curso!");
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	public static void inserirDisciplina(Disciplina disciplina, Curso curso){
			EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			CursoDAO dao = new CursoDAO(manager);
			curso.setDisciplinas(new ArrayList<>());
			curso.getDisciplinas().add(disciplina);
			
			disciplina.setCursos(new ArrayList<>());
			disciplina.getCursos().add(curso);
			dao.atualizar(curso);
			manager.getTransaction().commit();
		}catch (Exception e){
			System.out.println("Disciplina não pode ser inserida no curso!");
			manager.getTransaction().rollback();
		}finally{
			manager.close();
		}

	}
	
	
	
	
	
	
	
}

