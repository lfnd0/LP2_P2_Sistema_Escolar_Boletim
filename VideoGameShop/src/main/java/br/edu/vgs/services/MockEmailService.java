package br.edu.vgs.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractEmailService {

	private static Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void enviaEmail(SimpleMailMessage mensagem) {
		LOG.info(mensagem.toString());
	}
}