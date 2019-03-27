package br.edu.vgs.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.vgs.domain.Compra;
import br.edu.vgs.services.CompraService;

@RestController
@RequestMapping(value="/vgs/compras")
public class CompraResource {
	
	@Autowired
	private CompraService compraService;
	
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	public ResponseEntity<Compra> find(@PathVariable Integer id) {
		Compra compra = compraService.find(id);
		return ResponseEntity.ok().body(compra);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Compra compra) {
		compra = compraService.insert(compra);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{/id}").buildAndExpand(compra.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}