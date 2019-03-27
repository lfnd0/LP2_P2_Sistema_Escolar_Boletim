package br.edu.vgs.domain.enums;

public enum CompraStatus {
	
	CANCELADO(1, "Cancelado"),
	PENDENTE(2, "Pendente"),
	APROVADO(3, "Aprovado");
	
	private int codigo;
	private String descricao;
	
	private CompraStatus(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static CompraStatus toEnum(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		for(CompraStatus status : CompraStatus.values()) {
			if(codigo.equals(status.getCodigo())) {
				return status;
			}
		}
		
		throw new IllegalArgumentException("Status inválido: " + codigo);
	}
}