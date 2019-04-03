package br.edu.vgs.domain;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Compra implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date data;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="compra")
	private Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@OneToMany(mappedBy="id.compra")
	private Set<ItemCompra> itens = new HashSet<>();
	
	public Compra() {}

	public Compra(Integer id, Date data, Usuario usuario) {
		this.id = id;
		this.data = data;
		this.usuario = usuario;
	}
	
	public double getValorTotal() {
		double soma = 0.00;
		for (ItemCompra item : itens) {
			soma = soma + item.getSubtotal();
		}
		return soma;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}
	
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<ItemCompra> getItens() {
		return itens;
	}

	public void setItens(Set<ItemCompra> itens) {
		this.itens = itens;
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
		Compra other = (Compra) obj;
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
		SimpleDateFormat sDF = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder builder = new StringBuilder();
		builder.append("Obrigado por realizar sua compra na VideoGameShop\n\n");
		builder.append("Detalhes da compra:");
		builder.append("\nNúmero da compra: ");
		builder.append(getId());
		builder.append("\nData: ");
		builder.append(sDF.format(getData()));
		builder.append("\nUsuário: ");
		builder.append(getUsuario().getNome());
		builder.append("\nStatus do pagamento: ");
		builder.append(getPagamento().getStatus().getDescricao());
		builder.append("\n\nJogos escolhidos:\n");
		for (ItemCompra item : getItens()) {
			builder.append(item.toString());
		}
		builder.append("\nValor total: ");
		builder.append(nF.format(getValorTotal()));
		builder.append("\nATENÇÃO:"
				+ " somente após a confirmação do pagamento, é que a VideoGameShop enviará um novo"
				+ " e-mail contendo o link para o(s) download(s) do(s) seu(s) jogo(s).");
		return builder.toString();
	}
}