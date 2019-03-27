package br.edu.vgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.vgs.domain.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {}