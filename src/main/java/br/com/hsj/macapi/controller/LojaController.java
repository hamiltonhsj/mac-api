package br.com.hsj.macapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hsj.macapi.domain.Loja;

@RestController
public class LojaController {

	@GetMapping(value = "/lojas")
	public List<Loja> listar() {
		Loja loja = new Loja(1, "Emiliano Perneta", 119);
		Loja loja2 = new Loja(2, "Teste", 2);
		
		List<Loja> lojas = new ArrayList<>();
		lojas.add(loja);
		lojas.add(loja2);
		
		return lojas;
	}
}
