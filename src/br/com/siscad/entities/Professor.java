package br.com.siscad.entities;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Professor extends Usuario implements Autenticavel {

	
	private String areaAtuacao;
	private String titulacao;

	@ManyToMany
	@JoinTable(name="Curso_Professor",  
	joinColumns=@JoinColumn(name="curso_ID"),  
	inverseJoinColumns=@JoinColumn(name="prof_ID"))
	private List<Curso> cursos;
	
	@OneToMany(mappedBy = "professor")
	private List<Turma> turmas;
	
	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	@Override
	public Long getId() {		
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}

	@Override
	public boolean autentica(int senha) {
		return true;
		
	}
	
	

}
