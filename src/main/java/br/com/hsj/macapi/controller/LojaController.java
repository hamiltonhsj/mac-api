package br.com.hsj.macapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.hsj.macapi.domain.Loja;
import br.com.hsj.macapi.exception.BusinessException;
import br.com.hsj.macapi.service.LojaService;

@RestController
@RequestMapping(value="/lojas")
public class LojaController {
	
	@Autowired
	private LojaService lojaService;

	@GetMapping
	public ResponseEntity<List<Loja>> findAll() {
		
		return ResponseEntity.ok().body(lojaService.findAll());
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<Loja> find(@PathVariable Integer id) {
		return ResponseEntity.ok().body(lojaService.find(id));
	}
	
	@PutMapping
	public ResponseEntity<Void> save(@RequestBody Loja _loja) throws BusinessException {
		Loja loja = null;

		loja = lojaService.save(_loja);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(loja.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Loja _loja, @PathVariable Integer id) throws BusinessException {
		
		_loja.setId(id);
		
		_loja = lojaService.save(_loja);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(_loja.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
