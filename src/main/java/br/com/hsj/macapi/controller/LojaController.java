package br.com.hsj.macapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LojaController {

	@GetMapping(value = "/lojas")
	public String listar() {
		return "REST OK!";
	}
}
