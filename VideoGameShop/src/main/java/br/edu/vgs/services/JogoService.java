package br.edu.vgs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.vgs.domain.Jogo;
import br.edu.vgs.repositories.JogoRepository;
import br.edu.vgs.services.exceptions.ObjectNotFoundException;


@Service
public class JogoService {

	@Autowired
	private JogoRepository jogoRepository;
	
	public List<Jogo> findAll() {
		return jogoRepository.findAll();
	}
	
	public Jogo find(Integer id) {
		Optional<Jogo> jogoService = jogoRepository.findById(id);
		return jogoService.orElseThrow(() -> new ObjectNotFoundException(
				"Jogo não encontrado! Código: " + id + ", consulta: " + Jogo.class.getName()));
	}
}