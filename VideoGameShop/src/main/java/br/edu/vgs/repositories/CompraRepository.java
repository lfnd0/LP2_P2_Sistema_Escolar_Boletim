package br.edu.vgs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.vgs.domain.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {}