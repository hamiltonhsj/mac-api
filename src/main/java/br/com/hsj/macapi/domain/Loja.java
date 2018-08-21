package br.com.hsj.macapi.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Loja extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	private Integer numero;
	
	@ManyToOne  
	@JoinColumn(name="endereco_id")
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
		return String.format("Loja [id=%s, nome=%s, numero=%s, endereco=[%s]]", id, nome, numero, endereco.toString());
	}
}
