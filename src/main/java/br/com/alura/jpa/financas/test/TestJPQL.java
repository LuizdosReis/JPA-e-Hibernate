package br.com.alura.jpa.financas.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.jpa.financas.dao.JPAUtil;
import br.com.alura.jpa.financas.modelo.Conta;
import br.com.alura.jpa.financas.modelo.Movimentacao;
import br.com.alura.jpa.financas.modelo.TipoMovimentacao;

public class TestJPQL {
	
	public static void main(String[] args) {
		EntityManager maneger = new JPAUtil().getEntityManeger();
		
		Conta c = new Conta();
		c.setId(1);
		
		Query query = maneger.createQuery("select m from Movimentacao m where m.conta=:c"
											+" and m.tipoMovimentacao =:m"
											+" order by m.valor desc");
		
		query.setParameter("c", c);
	 	query.setParameter("m",TipoMovimentacao.SAIDA);
		
		List<Movimentacao> lista = query.getResultList();
		
		for (Movimentacao m : lista) {
			System.out.println("Descricao: "+m.getDescricao());
			System.out.println("Valor: "+m.getValor());
		}
		
	}

}
