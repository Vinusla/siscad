package br.com.siscad.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "disciplina", sequenceName = "disciplina_name", allocationSize = 1)

public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "disciplina")
	private int id;
	private String nome;
	private String area;

	@ManyToOne
	private Curso curso;

	@OneToMany(mappedBy = "turma")
	private List<Turma> turmas;

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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
