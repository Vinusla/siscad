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
@SequenceGenerator(name = "curso", sequenceName = "curso_seq", allocationSize = 1)
public class Curso extends AbstractEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso")
	private Long id;
	private String nome;
	private String tipo;

	//@OneToMany(mappedBy = "curso")//o Aluno tem que informar a qual curso ele pertence. Isso deve ser feito na hora de criar o aluno. cirar aluno e no aluno.setCurso(objeto curso)
	
	@ManyToMany(mappedBy="cursos")	
	private List<Aluno> alunos;

	@ManyToMany(mappedBy = "cursos")	
	private List<Professor> professores;

	@OneToMany(mappedBy = "curso")
	private List<Disciplina> disciplinas;

	@Override
	public Long getId() {
		return (long) id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	

}
