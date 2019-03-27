package br.edu.vgs.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import br.edu.vgs.domain.enums.CompraStatus;

@Entity
@JsonTypeName("cartao")
public class Cartao extends Pagamento {

	private static final long serialVersionUID = 1L;
	
	private Integer parcelas;
	
	public Cartao() {}

	public Cartao(Integer id, CompraStatus status, Compra compra, Integer parcelas) {
		super(id, status, compra);
		this.parcelas = parcelas;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}
}