package br.com.alura.jpa.financas.test;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.alura.jpa.financas.dao.JPAUtil;
import br.com.alura.jpa.financas.modelo.Conta;
import br.com.alura.jpa.financas.modelo.Movimentacao;
import br.com.alura.jpa.financas.modelo.TipoMovimentacao;

public class TestandoRelacionamento {
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setTitular("Joao Ferreira");
		conta.setBanco("HSBC");
		conta.setNumero("123345");
		conta.setAgencia("321");
		
		Movimentacao movimentacao = new Movimentacao();
		
		movimentacao.setConta(conta);
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Pgto Luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("120.35"));
			
		EntityManager maneger = new JPAUtil().getEntityManeger();

		maneger.getTransaction().begin();

		maneger.persist(conta);
		
		maneger.persist(movimentacao);

		maneger.getTransaction().commit();
	
		maneger.close();
		

	}

}
