package br.edu.vgs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.vgs.domain.Genero;
import br.edu.vgs.repositories.GeneroRepository;
import br.edu.vgs.services.exceptions.ObjectNotFoundException;


@Service
public class GeneroService {

	@Autowired
	private GeneroRepository generoRepository;
	
	public List<Genero> findAll() {
		return generoRepository.findAll();
	}
	
	public Genero find(Integer id) {
		Optional<Genero> generoService = generoRepository.findById(id);
		return generoService.orElseThrow(() -> new ObjectNotFoundException(
				"Gênero de jogo(s) não encontrado(s)! Código: " + id + ", consulta: " + Genero.class.getName()));
	}
}