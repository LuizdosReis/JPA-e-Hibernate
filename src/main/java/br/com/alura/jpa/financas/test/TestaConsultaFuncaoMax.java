package br.com.alura.jpa.financas.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.financas.dao.JPAUtil;
import br.com.alura.jpa.financas.modelo.Conta;

public class TestaConsultaFuncaoMax {
	public static void main(String[] args) {
		EntityManager maneger = new JPAUtil().getEntityManeger();
		
		Conta conta = maneger.find(Conta.class, 1);
		
		TypedQuery<BigDecimal> query = maneger.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta",BigDecimal.class);
		
		query.setParameter("pConta", conta);
		
		BigDecimal maior = query.getSingleResult();
		
		System.out.println(maior);
		
		maneger.close();
		
	
		
	}

}
