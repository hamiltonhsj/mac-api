package br.com.hsj.macapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.hsj.macapi.domain.Loja;
import br.com.hsj.macapi.exception.BusinessException;
import br.com.hsj.macapi.exception.ObjectNotFoundException;
import br.com.hsj.macapi.repository.LojaRepository;

@Service
public class LojaService {
	
	@Autowired
	private LojaRepository repo;
	
	public List<Loja> findAll() {
		return repo.findAll();

	}
	
	public Loja save(Loja _loja) throws BusinessException {
		Loja loja = null;
		
		try {
			loja = repo.save(_loja);
		
		} catch (DataIntegrityViolationException e) {
			throw new BusinessException("Já existe uma loja cadastrada com este número", e);
		}
		
		return loja;
	}
	
	public Loja find(Integer _id) {
		Optional<Loja> obj = repo.findById(_id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				String.format("Objeto não encontrado. Id: %s, Tipo: %s.", _id, Loja.class.getName())));
	}
}
