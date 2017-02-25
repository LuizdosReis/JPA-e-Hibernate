package br.com.alura.jpa.financas.test;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.jpa.financas.dao.JPAUtil;
import br.com.alura.jpa.financas.modelo.Conta;

public class TestaConsultaFuncaoCount {
	public static void main(String[] args) {
		EntityManager maneger = new JPAUtil().getEntityManeger();
		
		Conta conta = maneger.find(Conta.class, 1);
		
		Query query = maneger.createQuery("select count(m) from Movimentacao m where m.conta = :pConta");
		
		query.setParameter("pConta", conta);
		
		Long qtd = (Long) query.getSingleResult();
		
		System.out.println(qtd);
		
		maneger.close();
		
	
		
	}

}
