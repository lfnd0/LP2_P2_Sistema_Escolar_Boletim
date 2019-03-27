package br.edu.vgs.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.vgs.domain.Jogo;
import br.edu.vgs.domain.DTO.JogoDTO;
import br.edu.vgs.services.JogoService;

@RestController
@RequestMapping(value="/vgs/jogos")
public class JogoResource {
	
	@Autowired
	private JogoService jogoService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<JogoDTO>> findAll() {
		List<Jogo> lista = jogoService.findAll();
		List<JogoDTO> listaDTO = lista.stream().map(jogo -> new JogoDTO(jogo)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	public ResponseEntity<Jogo> find(@PathVariable Integer id) {
		Jogo jogo = jogoService.find(id);
		return ResponseEntity.ok().body(jogo);
	}
}