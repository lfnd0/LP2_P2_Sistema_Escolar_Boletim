package br.edu.vgs.configuration;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.edu.vgs.services.BancoDadosService;
import br.edu.vgs.services.EmailService;
import br.edu.vgs.services.MockEmailService;

@Configuration
@Profile("teste")
public class TesteConfiguration {

	@Autowired
	private BancoDadosService bancoDadosService;
	
	@Bean
	public boolean instantiateDataBase() throws ParseException{
		bancoDadosService.instantiateDatabase();
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
}