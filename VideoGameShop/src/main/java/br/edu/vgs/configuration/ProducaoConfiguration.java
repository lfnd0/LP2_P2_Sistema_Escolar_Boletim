package br.edu.vgs.configuration;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.edu.vgs.services.BancoDadosService;
import br.edu.vgs.services.EmailService;
import br.edu.vgs.services.SmtpEmailService;

@Configuration
@Profile("producao")
public class ProducaoConfiguration {

	@Autowired
	private BancoDadosService bancoDadosService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String chave;
	
	@Bean
	public boolean instantiateDataBase() throws ParseException{
		if (!"create".equals(chave)) {
			return false;
		}
		bancoDadosService.instantiateDatabase();
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}