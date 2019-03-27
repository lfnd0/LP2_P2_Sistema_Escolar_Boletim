package br.edu.vgs.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemCompraPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="compra_id")
	private Compra compra;
	
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Jogo jogo;
	
	public Compra getCompra() {
		return compra;
	}
	
	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Jogo getJogo() {
		return jogo;
	}
	
	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compra == null) ? 0 : compra.hashCode());
		result = prime * result + ((jogo == null) ? 0 : jogo.hashCode());
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
		ItemCompraPK other = (ItemCompraPK) obj;
		if (compra == null) {
			if (other.compra != null)
				return false;
		} else if (!compra.equals(other.compra))
			return false;
		if (jogo == null) {
			if (other.jogo != null)
				return false;
		} else if (!jogo.equals(other.jogo))
			return false;
		return true;
	}
}