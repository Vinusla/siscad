package br.com.siscad.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Aluno extends Usuario {
	
		
	@ManyToMany
	@JoinTable(name="Curso_Aluno",
	joinColumns=@JoinColumn(name="curso_ID"),
	inverseJoinColumns=@JoinColumn(name="aluno_ID"))
	private List<Curso> cursos;
	
	@Temporal(TemporalType.DATE)
	private Date dtVinculo;

	public Date getDtVinculo() {
		return dtVinculo;
	}

	public void setDtVinculo(Date dtVinculo) {
		this.dtVinculo = dtVinculo;
	}
	
	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public Long getId() {
		
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
		
	}
	
	
}