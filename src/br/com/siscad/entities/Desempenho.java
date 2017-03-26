package br.com.siscad.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Desempenho {
	
	@ManyToOne
	private Aluno aluno;
	@OneToMany
	private List<Nota> notas;
	@ManyToOne
	private Turma turma;

}
