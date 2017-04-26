package br.com.siscad.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.siscad.entities.AbstractEntity;

public abstract class AbstractDAO<T extends AbstractEntity> {

	EntityManager manager;
	
	public EntityManager getEntityManger(){
		EntityManagerFactory factory = null;
		EntityManager entityManager = null;
		
		try{
			if(factory ==null)
				factory = Persistence.createEntityManagerFactory("siscad");
			entityManager = factory.createEntityManager();
			manager = entityManager;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return entityManager;		
	}	
	
	public AbstractDAO(EntityManager manager){
		this.manager = manager;
	}
	
	public AbstractDAO(){
		
	}
	
	public void inserir(T entity){
		manager.persist(entity);
	}
	
	public void atualizar(T entity){
		manager.merge(entity);
	}
	
	public void excluir(T entity){
		entity = manager.find(entityClass(), entity.getId());
		manager.remove(entity);
	}
	
	public abstract Class<T> entityClass();
	

	public T buscarPorId(Long id){		
		return manager.find(entityClass(), id);
	}
	
	public List<T> listar(){
		Query query =  manager.createQuery("select c from "+ entityClass().getSimpleName()+" c");
		return  query.getResultList();
		
	}


}
