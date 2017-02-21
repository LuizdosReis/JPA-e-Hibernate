package br.com.alura.jpa.financas.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.financas.modelo.Conta;



public class Test {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setTitular("Joao Ferreira");
		conta.setBanco("HSBC");
		conta.setNumero("123345");
		conta.setAgencia("321");

		EntityManagerFactory createEntityManagerFactory = Persistence.createEntityManagerFactory("financas");
		EntityManager manager = createEntityManagerFactory.createEntityManager();

		manager.getTransaction().begin();

		manager.persist(conta);
		
		manager.getTransaction().commit();

		manager.close();
	}

}
