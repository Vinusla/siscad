package br.com.siscad.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "turma", sequenceName = "Turma_name", allocationSize = 1)

public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turma")	
	private int id;
	private String semestre;
	private int ano;

	@ManyToOne
	private Disciplina disciplina;
	
	@ManyToOne
	private Professor professor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

}
