package br.com.siscad.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "nota", sequenceName = "nota_seq", allocationSize = 1)
public class Nota extends Observable {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="nota")	
	private Long id;
	private int unidade;
	private float nota;
	private float peso;

	private List<Observer> observers = new ArrayList<Observer>();
	
	@ManyToOne
	public Desempenho desempenho;
	
	public int getUnidade() {
		return unidade;
	}

	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	@Override
	public Long getId() {
		return  id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer ob : observers) {
			System.out.println("Notificando observers!");
			ob.update(this.nota);
		}
	}
	
	
	
}