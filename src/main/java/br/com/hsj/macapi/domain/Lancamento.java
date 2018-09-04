package br.com.hsj.macapi.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Lancamento extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne  
	@JoinColumn(name="integrante_id")
	private Pessoa integrante;
	
	@ManyToOne  
	@JoinColumn(name="tipo_lancamento_id")
	private TipoLancamento tipoLancamento;
	
	@Column(nullable = false, scale = 2)
	private BigDecimal valor;
	
	@Column(nullable = false)
	private LocalDate data;
	
	@Column(nullable = false)
	private String descricao;

	public Pessoa getIntegrante() {
		return integrante;
	}

	public void setIntegrante(Pessoa integrante) {
		this.integrante = integrante;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
