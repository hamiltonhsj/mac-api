package br.com.hsj.macapi.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name="endereco_pessoa")
public class EnderecoPessoa {
	
	@EmbeddedId
	private EnderecoPessoaPK id;

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false)
	private TipoEndereco tipo;
	
	@Embedded
	private Auditoria auditoria;

	public EnderecoPessoaPK getId() {
		return id;
	}

	public void setId(EnderecoPessoaPK id) {
		this.id = id;
	}

	public TipoEndereco getTipo() {
		return tipo;
	}

	public void setTipo(TipoEndereco tipo) {
		this.tipo = tipo;
	}
	
	public Auditoria getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoPessoa other = (EnderecoPessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
