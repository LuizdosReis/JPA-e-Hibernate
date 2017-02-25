package br.com.alura.jpa.financas.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.jpa.financas.dao.JPAUtil;
import br.com.alura.jpa.financas.modelo.Conta;

public class TestaMovimentacaoConta {
	public static void main(String[] args) {
		EntityManager maneger = new JPAUtil().getEntityManeger();
		
		Query query = maneger.createQuery("select distinct c from Conta c join fetch c.movimentacoes");
		
		//query.setParameter("pId",2);
		
		List<Conta> resultList = query.getResultList();
		
		maneger.close();
		
		for (Conta conta : resultList) {
			System.out.println(conta.getMovimentacoes().size());
		}
		
		
	}

}
