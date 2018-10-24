package br.com.hsj.macapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.hsj.macapi.domain.Pessoa;
import br.com.hsj.macapi.exception.BusinessException;
import br.com.hsj.macapi.exception.ObjectNotFoundException;
import br.com.hsj.macapi.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;
	
	public List<Pessoa> findAll() {
		return repo.findAll();

	}
	
	public Pessoa save(Pessoa _pessoa) throws BusinessException {
		Pessoa pessoa = null;
		
		try {
			pessoa = repo.save(_pessoa);
		
		} catch (DataIntegrityViolationException e) {
			throw new BusinessException("Já existe uma pessoa cadastrada.", e);
		}
		
		return pessoa;
	}
	
	public Pessoa find(Integer _id) {
		Optional<Pessoa> obj = repo.findById(_id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				String.format("Objeto não encontrado. Id: %s, Tipo: %s.", _id, Pessoa.class.getName())));
	}
	
}
