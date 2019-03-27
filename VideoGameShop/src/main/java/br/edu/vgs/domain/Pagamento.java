package br.edu.vgs.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import br.edu.vgs.domain.enums.CompraStatus;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
public abstract class Pagamento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	private Integer status;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="compra_id")
	@MapsId
	private Compra compra;
	
	public Pagamento() {}

	public Pagamento(Integer id, CompraStatus status, Compra compra) {
		this.id = id;
		this.status = (status==null) ? null: status.getCodigo();
		this.compra = compra;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Integer getId() {
		return id;
	}

	public CompraStatus getStatus() {
		return CompraStatus.toEnum(status);
	}
	
	public void setStatus(CompraStatus status) {
		this.status = status.getCodigo();
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
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}