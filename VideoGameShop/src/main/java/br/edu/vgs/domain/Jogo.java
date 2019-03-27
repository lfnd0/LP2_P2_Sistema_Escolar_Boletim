package br.edu.vgs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Jogo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double preco;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="JOGO_GENERO", joinColumns=@JoinColumn(name="jogo_id"), inverseJoinColumns=@JoinColumn(name="genero_id"))
	private List<Genero> generos = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="id.jogo")
	private Set<ItemCompra> itens = new HashSet<>();
	
	public Jogo() {}
	
	public Jogo(Integer id, String nome, Double preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}
	
	@JsonIgnore
	public List<Compra> getCompras() {
		List<Compra> lista = new ArrayList<>();
		for (ItemCompra itemCompra: itens) {
			lista.add(itemCompra.getCompra());
		}
		return lista;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public List<Genero> getGeneros() {
		return generos;
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
		Jogo other = (Jogo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}