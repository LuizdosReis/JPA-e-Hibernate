package br.com.alura.jpa.financas.test;

import javax.persistence.EntityManager;

import br.com.alura.jpa.financas.dao.JPAUtil;
import br.com.alura.jpa.financas.dao.MovimentacaoDao;
import br.com.alura.jpa.financas.modelo.Conta;
import br.com.alura.jpa.financas.modelo.TipoMovimentacao;

public class TestaConsultaFuncaoMedia {
	public static void main(String[] args) {
		
		EntityManager maneger = new JPAUtil().getEntityManeger();
		
		Conta c = new Conta();
		c.setId(1);
		
		MovimentacaoDao movimentacaoDao = new MovimentacaoDao(maneger);
		
		Double media = movimentacaoDao.mediaDaConta(c);
		Long totalDeMovimentcoes = movimentacaoDao.totalDeMovimentcoes(c);
		
		System.out.println(totalDeMovimentcoes);
		
		System.out.println(media);
		
		
	}
	
	
	

}
