package br.com.alura.jpa.financas.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.financas.modelo.Conta;
import br.com.alura.jpa.financas.modelo.TipoMovimentacao;

public class MovimentacaoDao {

	private EntityManager maneger;

	public MovimentacaoDao(EntityManager maneger) {
		this.maneger = maneger;
	}

	public Double mediaDaConta(Conta c) {
		String jpql = "select avg(m.valor) from Movimentacao m where m.conta =:pConta and m.tipoMovimentacao = 'SAIDA'";
		TypedQuery<Double> query = maneger.createQuery(jpql,Double.class);
		query.setParameter("pConta",c);
		return query.getSingleResult();
	}
	
	public Long totalDeMovimentcoes(Conta c){
		TypedQuery<Long> query = maneger.createNamedQuery("totalDeMovimentacoes",Long.class);
		query.setParameter("pConta", c);
		return query.getSingleResult();		
	}

	

}
