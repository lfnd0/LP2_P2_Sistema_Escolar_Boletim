package br.edu.vgs.domain.DTO;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.edu.vgs.domain.Usuario;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="O nome de usuário é obrigatório.")
	@Length(min=4, max=100, message="Quantidade de caractes inválidos, respeite o limite de caracteres que deve ser entre 4-100.")
	private String nome;
	
	@NotEmpty(message="O campo de e-mail é obrigatório.")
	@Email(message="E-mail inválido.")
	private String email;
	
	public UsuarioDTO() {}

	public UsuarioDTO(Usuario usuario) {
		id = usuario.getId();
		nome = usuario.getNome();
		email = usuario.getEmail();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}