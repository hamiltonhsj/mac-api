package br.com.hsj.macapi.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Embeddable
public class Auditoria {

	@Column(name="criado_por", insertable = true, nullable = true)
	protected String criadoPor;
	
	@Column(name="criado_em", insertable = true, nullable = true)
	protected LocalDateTime criadoEm;
	
	@Column(name="atualizado_por", updatable = true, nullable = true)
	protected String atualizadoPor;
	
	@Column(name="atualizado_em", updatable = true, nullable = true)
	protected LocalDateTime atualizadoEm;
	
	public String getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(String criadoPor) {
		this.criadoPor = criadoPor;
	}

	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(LocalDateTime criadoEm) {
		this.criadoEm = criadoEm;
	}

	public String getAtualizadoPor() {
		return atualizadoPor;
	}

	public void setAtualizadoPor(String atualizadoPor) {
		this.atualizadoPor = atualizadoPor;
	}

	public LocalDateTime getAtualizadoEm() {
		return atualizadoEm;
	}

	public void setAtualizadoEm(LocalDateTime atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}
}
