package br.com.hsj.macapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Endereco extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private String logradouro;
	
	@Column(nullable = false)
	private String tipo;
	
	@Column(nullable = false)
	private Integer numero;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = false)
	private String cep;

	@Column(nullable = true)
	private String complemento;

	@Column(nullable = false)
	private String cidade;
	
	@Column(nullable = false)
	private String estado;
	
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return String.format(
				"Endereco [logradouro=%s, tipo=%s, numero=%s, bairro=%s, cep=%s, complemento=%s, cidade=%s, estado=%s, tipoEndereco=%s]",
				logradouro, tipo, numero, bairro, cep, complemento, cidade, estado);
	}

	
}
