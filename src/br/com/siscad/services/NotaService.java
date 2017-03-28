package br.com.siscad.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.siscad.dao.AlunoDAO;
import br.com.siscad.entities.Aluno;

public class NotaService {
	
	static EntityManagerFactory fac  = Persistence.createEntityManagerFactory("siscad");
	
	
}
