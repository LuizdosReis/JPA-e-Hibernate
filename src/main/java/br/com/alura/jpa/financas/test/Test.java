package br.com.alura.jpa.financas.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.financas.dao.JPAUtil;
import br.com.alura.jpa.financas.modelo.Conta;



public class Test {

	private static Conta find2;

	public static void main(String[] args) {

		
		double inicio = System.currentTimeMillis();
		
		Conta conta = new Conta();
		conta.setTitular("Joao Ferreira");
		conta.setBanco("HSBC");
		conta.setNumero("123345");
		conta.setAgencia("321");

		EntityManager manager =  new JPAUtil().getEntityManeger();

		manager.getTransaction().begin();

		//neste momento a conta se encontra no modo transient ou seja ainda nao esta no banco
		manager.persist(conta);
		//depois do metodo persist ela passa a ser managed
		
		//retorna a conta pelo id e deixa no estado Managed ou seja qualquer alteracao antes de o maneger seja fechado 
		//sera refletida no banco
		Conta find = manager.find(Conta.class,1);
		
		//so de alteramos um valor a alteracao ja é persistida no banco
		find.setAgencia("152");
		
		manager.getTransaction().commit();

		manager.close();
		
		//como alteramos algo depois de fechar o manager a conta vai para o modo Detached, ou seja ela existe no banco 
		//mais esta desatualizada
		conta.setBanco("152");
		
		EntityManager em = new JPAUtil().getEntityManeger();
		em.getTransaction().begin();
		
		// neste momento a JPA tras a conta do banco e verifica se precisa fazer um update na mesma e deixa ela no 
		//estado Managed ate que o maneger seja fechado;
		em.merge(conta);
		
		em.getTransaction().commit();
		
		em.close();
		
		
		EntityManager em1 = new JPAUtil().getEntityManeger();
		em1.getTransaction().begin();
		
		// para removermos uma conta primeiro precisamos deixa-la em estado maneged e depois chamado o metodo remove
		Conta contaASerRemovida = em1.find(Conta.class, 3);
		
		em1.remove(contaASerRemovida);
		
		
		em1.getTransaction().commit();
		
		em1.close();

		
		
		
		 double fim = System.currentTimeMillis();
	     System.out.println("Executado em: " + (fim - inicio)/1000 + "s");
	}

}
