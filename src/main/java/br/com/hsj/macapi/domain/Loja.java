package br.com.hsj.macapi.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Loja extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private Integer numero;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Endereco endereco;
	
	public Loja() {
		
	}
	
	public Loja(Integer id, String nome, Integer numero) {
		super();
		this.setId(id);
		this.nome = nome;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}
	

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return String.format("Loja [nome=%s, numero=%s, endereco=%s]", nome, numero, endereco);
	}
	
}
