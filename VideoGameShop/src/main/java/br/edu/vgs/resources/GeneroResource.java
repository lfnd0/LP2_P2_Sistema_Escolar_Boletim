package br.edu.vgs.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.vgs.domain.Genero;
import br.edu.vgs.domain.DTO.GeneroDTO;
import br.edu.vgs.services.GeneroService;

@RestController
@RequestMapping(value="/vgs/generos")
public class GeneroResource {
	
	@Autowired
	private GeneroService generoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<GeneroDTO>> findAll() {
		List<Genero> lista = generoService.findAll();
		List<GeneroDTO> listaDTO = lista.stream().map(genero -> new GeneroDTO(genero)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Genero> find(@PathVariable Integer id) {
		Genero genero = generoService.find(id);
		return ResponseEntity.ok().body(genero);
	}
}