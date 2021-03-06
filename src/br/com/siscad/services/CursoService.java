package br.com.siscad.services;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mchange.v2.resourcepool.ResourcePool.Manager;

import br.com.siscad.dao.AlunoDAO;
import br.com.siscad.dao.CursoDAO;
import br.com.siscad.dao.DisciplinaDAO;
import br.com.siscad.dao.ProfessorDAO;
import br.com.siscad.entities.Curso;
import br.com.siscad.entities.Professor;
import br.com.siscad.entities.Disciplina;;


public class CursoService {
	
	public static void CadastrarCurso(Curso curso){

		CursoDAO dao = new CursoDAO();
		EntityManager manager = dao.getEntityManger();
		
		try{
			manager.getTransaction().begin();			
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
		CursoDAO dao = new CursoDAO();
		EntityManager manager = dao.getEntityManger();
		manager.getTransaction().begin();
		try{			
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
		CursoDAO dao = new CursoDAO();
		EntityManager manager = dao.getEntityManger();
		try{
			manager.getTransaction().begin();			
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
		CursoDAO dao = new CursoDAO();
		EntityManager manager = dao.getEntityManger();
		try{
			manager.getTransaction().begin();			
			dao.excluir(curso);
			manager.getTransaction().commit();
		}catch (Exception e){
			System.out.println("Curso n�o removido!");
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	public static void inserirProfessorNoCurso(Professor professor,Curso curso){
		CursoDAO dao = new CursoDAO();
		ProfessorDAO professorDAO = new ProfessorDAO();
		
		
		EntityManager manager = dao.getEntityManger();
		
		try{
			manager.getTransaction().begin();
			professor.setCursos(new ArrayList<Curso>());
			professor.getCursos().add(curso);
			
			professorDAO.atualizar(professor);
			
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
		CursoDAO dao = new CursoDAO();
		
		EntityManager manager = dao.getEntityManger();
		try{
			
			manager.getTransaction().begin();
			System.out.println(curso.getNome());
			disciplina.setCurso(curso);			
			
			DisciplinaService.CadastrarDisciplina(disciplina);
			
			curso.setDisciplinas(new ArrayList<>());
			curso.getDisciplinas().add(disciplina);			
			disciplina.setCurso(curso);;
			dao.atualizar(curso);
			manager.getTransaction().commit();
		}catch (Exception e){
			e.printStackTrace();
			manager.getTransaction().rollback();
		}finally{
			manager.close();
		}

	}
	
	
}

