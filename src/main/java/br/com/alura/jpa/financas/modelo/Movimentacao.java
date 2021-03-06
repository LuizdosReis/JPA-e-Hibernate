package br.com.alura.jpa.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@NamedQuery(name="totalDeMovimentacoes",query="select count(m) from Movimentacao m where m.conta = :pConta")
@Entity
public class Movimentacao {

	@Id
	@GeneratedValue
	private Integer id;

	private BigDecimal valor;

	@Enumerated(EnumType.STRING) // para dissermos ao banco salvar o valor como
									// string
	private TipoMovimentacao tipoMovimentacao;

	@Temporal(TemporalType.TIMESTAMP) // salva no banco com data e hora
	private Calendar data;

	@ManyToOne
	private Conta conta;

	private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
