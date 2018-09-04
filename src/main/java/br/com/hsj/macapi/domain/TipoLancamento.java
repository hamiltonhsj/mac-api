package br.com.hsj.macapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name="tipo_lancamento")
public class TipoLancamento extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1365027218140281143L;

	@Column(nullable = false)
	private String descricao;
	
	@Enumerated(EnumType.ORDINAL)
	private CaracteristicaLancamento caracteristica;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public CaracteristicaLancamento getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(CaracteristicaLancamento caracteristica) {
		this.caracteristica = caracteristica;
	}

	@Override
	public String toString() {
		return String.format("TipoLancamento [id=%s, descricao=%s, caracteristisca=%s]", id, descricao, caracteristica == null ? null : caracteristica.getDescricao());
	}
	
	
}
