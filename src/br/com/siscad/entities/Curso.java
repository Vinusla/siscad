package br.com.siscad.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "curso", sequenceName = "curso_name", allocationSize = 1)
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso")
	private int id;
	private String nome;
	private String tipo;

	@OneToMany(mappedBy = "curso")//o Aluno tem que informar a qual curso ele pertence. Isso deve ser feito na hora de criar o aluno. cirar aluno e no aluno.setCurso(objeto curso)
	private List<Aluno> alunos;

	@ManyToMany(mappedBy = "curso")
	private List<Professor> professores;

	@OneToMany(mappedBy = "curso")
	private List<Disciplina> disciplinas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

}
