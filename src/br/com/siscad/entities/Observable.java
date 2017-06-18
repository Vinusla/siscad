package br.com.siscad.entities;

public abstract class Observable extends AbstractEntity{

	public void registerObserver(Observer observer) {
	}

	public void removeObserver(Observer observer) {
	}

	public void notifyObservers() {
	}
}
