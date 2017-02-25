package br.com.alura.jpa.financas.test;

import javax.persistence.EntityManager;

import br.com.alura.jpa.financas.dao.JPAUtil;
import br.com.alura.jpa.financas.modelo.Movimentacao;

public class TestaMovimentacaoConta {
	public static void main(String[] args) {
		EntityManager maneger = new JPAUtil().getEntityManeger();
		
		Movimentacao m = maneger.find(Movimentacao.class,2);
		
		System.out.println(m.getConta().getTitular());
	}

}
