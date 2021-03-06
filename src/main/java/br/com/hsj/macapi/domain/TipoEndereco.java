package br.com.hsj.macapi.domain;

public enum TipoEndereco {

	RESIDENCIAL(1, "Residencial"), 
	COMERCIAL(2, "Comercial");
	
	private Integer id;
	
	private String descricao;
	
	private TipoEndereco(Integer _id, String _descricao) {
		id = _id;
		descricao = _descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static TipoEndereco toEnum(Integer id) {           
		if (id == null) {             
			return null;         
		}           
		
		for (TipoEndereco x : TipoEndereco.values()) {             
			if (id.equals(x.getId())) {                 
				return x;             
			}         
		}         
		
		throw new IllegalArgumentException("Id inválido " + id);     
	} 
}
