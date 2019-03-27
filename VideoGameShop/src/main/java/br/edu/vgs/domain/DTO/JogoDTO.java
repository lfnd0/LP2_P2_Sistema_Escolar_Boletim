package br.edu.vgs.domain.DTO;

import java.io.Serializable;

import br.edu.vgs.domain.Jogo;

public class JogoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Double preco;
	
	public JogoDTO() {}
	
	public JogoDTO(Jogo jogo) {
		id = jogo.getId();
		nome = jogo.getNome();
		preco = jogo.getPreco();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
}