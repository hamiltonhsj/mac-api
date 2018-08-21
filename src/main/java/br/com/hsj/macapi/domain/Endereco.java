package br.com.hsj.macapi.domain;

import javax.persistence.Entity;

@Entity
public class Endereco extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String logradouro;
	
	private String tipo;
	
	private Integer numero;
	
	private String bairro;
	
	private String cidade;
	
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

	@Override
	public String toString() {
		return String.format("Endereco [id=%s, tipo=%s, logradouro=%s, numero=%s, bairro=%, cidade=%, estado=%]", id, tipo, logradouro, numero, bairro, cidade, estado);
	}
}
