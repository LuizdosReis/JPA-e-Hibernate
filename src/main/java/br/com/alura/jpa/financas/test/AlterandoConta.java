package br.com.alura.jpa.financas.test;

import javax.persistence.EntityManager;

import br.com.alura.jpa.financas.dao.JPAUtil;
import br.com.alura.jpa.financas.modelo.Conta;

public class AlterandoConta {
	public static void main(String[] args) {
		EntityManager maneger = new JPAUtil().getEntityManeger();

		maneger.getTransaction().begin();

		Conta conta = maneger.find(Conta.class, 1);

		maneger.getTransaction().commit();
		
		conta.setTitular("Joao Pedro");
		
		maneger.getTransaction().begin();
		
		maneger.merge(conta);

		maneger.getTransaction().commit();

		maneger.close();
		

	}

}
