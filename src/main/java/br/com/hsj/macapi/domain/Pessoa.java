package br.com.hsj.macapi.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
public class Pessoa extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String nome;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Endereco enderecoComercial;

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Endereco enderecoResidencial;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Loja loja;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Endereco getEnderecoComercial() {
		return enderecoComercial;
	}

	public void setEnderecoComercial(Endereco enderecoComercial) {
		this.enderecoComercial = enderecoComercial;
	}

	public Endereco getEnderecoResidencial() {
		return enderecoResidencial;
	}

	public void setEnderecoResidencial(Endereco enderecoResidencial) {
		this.enderecoResidencial = enderecoResidencial;
	}

	@Override
	public String toString() {
		return String.format("Pessoa [nome=%s, enderecoComercial=%s, enderecoResidencial=%s, loja=%s]", nome,
				enderecoComercial, enderecoResidencial, loja);
	}

}
