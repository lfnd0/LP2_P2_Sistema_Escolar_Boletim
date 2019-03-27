package br.edu.vgs.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.vgs.domain.Boleto;
import br.edu.vgs.domain.Cartao;

@Configuration
public class JacksonConfiguration {

	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(Cartao.class);
				objectMapper.registerSubtypes(Boleto.class);
				super.configure(objectMapper);
			}
		};
		return builder;
	}
}