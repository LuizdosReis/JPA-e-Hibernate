package br.com.alura.jpa.financas.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.financas.dao.JPAUtil;
import br.com.alura.jpa.financas.modelo.Conta;



public class Test {

	public static void main(String[] args) {

		
		double inicio = System.currentTimeMillis();
		
		Conta conta = new Conta();
		conta.setTitular("Joao Ferreira");
		conta.setBanco("HSBC");
		conta.setNumero("123345");
		conta.setAgencia("321");

		EntityManager manager =  new JPAUtil().getEntityManeger();

		manager.getTransaction().begin();

		manager.persist(conta);
		
		manager.getTransaction().commit();

		manager.close();
		
		 double fim = System.currentTimeMillis();
	     System.out.println("Executado em: " + (fim - inicio)/1000 + "s");
	}

}
