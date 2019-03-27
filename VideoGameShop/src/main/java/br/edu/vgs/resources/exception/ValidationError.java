package br.edu.vgs.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> listaErros = new ArrayList<>();
	
	public ValidationError(Integer status, String mensagem, Long time) {
		super(status, mensagem, time);
	}

	public List<FieldMessage> getErros() {
		return listaErros;
	}

	public void addErros(String nome, String mensagem) {
		listaErros.add(new FieldMessage(nome, mensagem));
	}	
}