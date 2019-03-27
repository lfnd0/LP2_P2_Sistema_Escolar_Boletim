package br.edu.vgs.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemCompra implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemCompraPK id = new ItemCompraPK();
	
	private Integer quantidade;
	private Double preco;
	
	public ItemCompra() {}
	
	public ItemCompra(Compra compra, Jogo jogo, Integer quantidade, Double preco) {
		id.setCompra(compra);
		id.setJogo(jogo);
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public double getSubtotal() {
		return preco * quantidade;
	}
	
	@JsonIgnore
	public Compra getCompra() {
		return id.getCompra();
	}
	
	public void setCompra(Compra compra) {
		id.setCompra(compra);
	}
	
	public Jogo getJogo() {
		return id.getJogo();
	}
	
	public void setJogo(Jogo jogo) {
		id.setJogo(jogo);
	}
	
	public ItemCompraPK getId() {
		return id;
	}

	public void setId(ItemCompraPK id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
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
		ItemCompra other = (ItemCompra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		NumberFormat nF = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		StringBuilder builder = new StringBuilder();
		builder.append("Nome do jogo: ");
		builder.append(getJogo().getNome());
		builder.append(", quantidade: ");
		builder.append(getQuantidade());
		builder.append(", preço do jogo: ");
		builder.append(nF.format(getPreco()));
		builder.append(", subtotal: ");
		builder.append(nF.format(getSubtotal()));
		builder.append("\n");
		return builder.toString();
	}
}