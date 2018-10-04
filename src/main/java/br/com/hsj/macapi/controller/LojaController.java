package br.com.hsj.macapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.hsj.macapi.domain.Loja;
import br.com.hsj.macapi.service.LojaService;

@RestController
public class LojaController {
	
	@Autowired
	private LojaService lojaService;

	@GetMapping(value = "/lojas")
	public List<Loja> listar() {
		
		return lojaService.buscarTodos();
	}
	
	@PutMapping(value = "/lojas")
	public ResponseEntity<Object> criar(@RequestBody Loja _loja) {
		
		
		Loja loja = lojaService.salvar(_loja);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(loja.getId()).toUri();

		return ResponseEntity.created(location).build();
		
	}
	
	@PutMapping(value = "/lojas/{id}")
	public ResponseEntity<Object> atualizar(@RequestBody Loja _loja, @PathVariable Integer id) {
		
		_loja.setId(id);
		
		Loja loja = lojaService.salvar(_loja);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(loja.getId()).toUri();

		return ResponseEntity.created(location).build();
		
	}
}
