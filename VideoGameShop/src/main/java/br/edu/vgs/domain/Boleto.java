package br.edu.vgs.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

import br.edu.vgs.domain.enums.CompraStatus;

@Entity
@JsonTypeName("boleto")
public class Boleto extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date vencimento;
	
	public Boleto() {}

	public Boleto(Integer id, CompraStatus status, Compra compra, Date vencimento) {
		super(id, status, compra);
		this.vencimento = vencimento;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}
}