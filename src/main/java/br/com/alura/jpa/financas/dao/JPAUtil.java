package br.com.alura.jpa.financas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("financas");
	
	
	public EntityManager getEntityManeger(){
		return entityManagerFactory.createEntityManager();
	}

}
