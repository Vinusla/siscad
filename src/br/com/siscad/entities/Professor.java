package br.com.siscad.entities;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Professor extends Usuario {

	private String areaAtuacao;
	private String titulacao;

	@ManyToMany
	private Curso curso;
	
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

}
