package br.edu.vgs.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import br.edu.vgs.domain.Compra;

public abstract class AbstractEmailService implements EmailService{

	@Value("${default.remetente}")
	private String remetente;
	
	@Override
	public void confirmacaoCompra(Compra compra) {
		SimpleMailMessage sMM = mensagemCompra(compra);
		enviaEmail(sMM);
	}

	protected SimpleMailMessage mensagemCompra(Compra compra) {
		SimpleMailMessage sMM = new SimpleMailMessage();
		sMM.setTo(compra.getUsuario().getEmail());
		sMM.setFrom(remetente);
		sMM.setSubject("VGS - Compra recebida! Número da compra: " + compra.getId());
		sMM.setSentDate(new Date(System.currentTimeMillis()));
		sMM.setText(compra.toString());
		return sMM;
	}
}