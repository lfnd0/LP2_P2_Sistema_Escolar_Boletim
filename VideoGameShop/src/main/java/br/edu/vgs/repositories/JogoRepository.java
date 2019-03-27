package br.edu.vgs.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.vgs.domain.Genero;
import br.edu.vgs.domain.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Integer> {
	
	@Transactional(readOnly=true)
	Page<Jogo> findDistinctByNomeContainingAndGenerosIn(String nome, List<Genero> generos, Pageable pageRequest);
}