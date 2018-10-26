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

import br.com.hsj.macapi.domain.TipoLancamento;
import br.com.hsj.macapi.exception.BusinessException;
import br.com.hsj.macapi.service.TipoLancamentoService;

@RestController
@RequestMapping(value="/tiposLancamentos")
public class TipoLancamentoController {

	@Autowired
	private TipoLancamentoService tipoLancamentoService;

	@GetMapping
	public ResponseEntity<List<TipoLancamento>> findAll() {
		
		return ResponseEntity.ok().body(tipoLancamentoService.findAll());
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<TipoLancamento> find(@PathVariable Integer id) {
		return ResponseEntity.ok().body(tipoLancamentoService.find(id));
	}
	
	@PutMapping
	public ResponseEntity<Void> save(@RequestBody TipoLancamento _loja) throws BusinessException {
		TipoLancamento tipo = null;

		tipo = tipoLancamentoService.save(_loja);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(tipo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody TipoLancamento _tipo, @PathVariable Integer id) throws BusinessException {
		
		_tipo.setId(id);
		
		_tipo = tipoLancamentoService.save(_tipo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(_tipo.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
}
