package br.com.hsj.macapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hsj.macapi.domain.Loja;
import br.com.hsj.macapi.repository.LojaRepository;

@Service
public class LojaService {
	
	@Autowired
	private LojaRepository repo;
	
	public List<Loja> buscarTodos() {
		return repo.findAll();

	}
	
	public Loja salvar(Loja _loja) {
		return repo.save(_loja);
	}
}
