package br.com.hsj.macapi.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Integrante extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nome;
	
	@ManyToOne
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
	
}
