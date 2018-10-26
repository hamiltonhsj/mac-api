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

import br.com.hsj.macapi.domain.Lancamento;
import br.com.hsj.macapi.domain.Pessoa;
import br.com.hsj.macapi.exception.BusinessException;
import br.com.hsj.macapi.service.LancamentoService;

@RestController
@RequestMapping(value="/lancamentos")
public class LancamentoController {

	@Autowired
	private LancamentoService lancamentoService;

	@PutMapping
	public ResponseEntity<Void> save(@RequestBody Lancamento _lancamento) throws BusinessException {
		Lancamento lancamento = null;

		lancamento = lancamentoService.save(_lancamento);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(lancamento.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value="/pessoa/{id}")
	public ResponseEntity<List<Lancamento>> findAll(@PathVariable Integer id) {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(id);
		
		return ResponseEntity.ok().body(lancamentoService.findByPessoa(pessoa));
	}
}
