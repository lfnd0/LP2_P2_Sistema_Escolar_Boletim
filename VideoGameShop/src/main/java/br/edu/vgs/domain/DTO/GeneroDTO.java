package br.edu.vgs.domain.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.edu.vgs.domain.Genero;

public class GeneroDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Esse campo é obrigatório, não pode ficar em branco.")
	@Length(min=3, max=10, message="Quantidade de caractes inválidos, respeite o limite de caracteres que deve ser entre 3-10.")
	private String nome;
	
	public GeneroDTO() {}
	
	public GeneroDTO(Genero genero) {
		id = genero.getId();
		nome = genero.getNome();
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
}