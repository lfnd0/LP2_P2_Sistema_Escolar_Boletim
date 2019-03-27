package br.edu.vgs.services;

import org.springframework.mail.SimpleMailMessage;

import br.edu.vgs.domain.Compra;

public interface EmailService {

	void confirmacaoCompra (Compra compra);
	
	void enviaEmail(SimpleMailMessage mensagem);
}