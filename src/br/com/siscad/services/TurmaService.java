package br.com.siscad.services;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import br.com.siscad.dao.TurmaDAO;
import br.com.siscad.entities.Aluno;
import br.com.siscad.entities.Disciplina;
import br.com.siscad.entities.Professor;
import br.com.siscad.entities.Turma;

public class TurmaService {

	
	public static void CadastrarTurma(Turma turma, Professor professor, Disciplina disciplina){

		TurmaDAO dao = new TurmaDAO();
		turma.setProfessor(professor);
		turma.setDisciplina(disciplina);
		
		professor.setTurmas(new ArrayList<Turma>());
		professor.getTurmas().add(turma);
		
		disciplina.setTurmas(new ArrayList<Turma>());
		disciplina.getTurmas().add(turma);
		
		EntityManager manager = dao.getEntityManger();
		manager.getTransaction().begin();		
		try{
						
			dao.inserir(turma);
			manager.getTransaction().commit();
		}catch (Exception e){
			e.printStackTrace();
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

