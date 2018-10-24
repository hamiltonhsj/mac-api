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
import br.com.hsj.macapi.domain.Pessoa;
import br.com.hsj.macapi.exception.BusinessException;
import br.com.hsj.macapi.service.PessoaService;

@RestController
@RequestMapping(value="/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() {
		
		return ResponseEntity.ok().body(pessoaService.findAll());
	}

	@GetMapping(value="/loja/{id}")
	public ResponseEntity<List<Pessoa>> findAll(@PathVariable Integer id) {
		
		Loja loja = new Loja();
		loja.setId(id);
		
		return ResponseEntity.ok().body(pessoaService.findByLoja(loja));
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Pessoa> find(@PathVariable Integer id) {
		return ResponseEntity.ok().body(pessoaService.find(id));
	}
	
	@PutMapping
	public ResponseEntity<Void> save(@RequestBody Pessoa _pessoa) throws BusinessException {
		Pessoa pessoa = null;

		pessoa = pessoaService.save(_pessoa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(pessoa.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Pessoa _pessoa, @PathVariable Integer id) throws BusinessException {
		
		_pessoa.setId(id);
		
		_pessoa = pessoaService.save(_pessoa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(_pessoa.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
