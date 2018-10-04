package br.com.hsj.macapi.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public class Base implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Integer id;
	
	@Embedded
	private Auditoria auditoria;
	
	@PrePersist
    public void prePersist() {
		if (auditoria == null) {
			auditoria = new Auditoria();
		}
		auditoria.setCriadoEm(LocalDateTime.now());
		auditoria.setCriadoPor("hamilton.hsj@gmail.com");
//		criadoPor = LoggedUser.get();
    }
 
    @PreUpdate
    public void preUpdate() {
    	if (auditoria == null) {
			auditoria = new Auditoria();
		}
    	auditoria.setAtualizadoEm(LocalDateTime.now());
    	auditoria.setAtualizadoPor("hamilton.hsj@gmail.com");
//    	atualizadoPor = LoggedUser.get();
    }
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
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
		Base other = (Base) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
