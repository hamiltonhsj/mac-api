package br.com.hsj.macapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hsj.macapi.domain.Lancamento;
import br.com.hsj.macapi.domain.Pessoa;
import br.com.hsj.macapi.exception.BusinessException;
import br.com.hsj.macapi.exception.ObjectNotFoundException;
import br.com.hsj.macapi.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository repo;
	
	public List<Lancamento> findAll() {
		return repo.findAll();

	}
	
	public Lancamento save(Lancamento _lancamento) throws BusinessException {
		Lancamento lancamento = null;
		
		lancamento = repo.save(_lancamento);
		
		return lancamento;
	}
	
	public Lancamento find(Integer _id) {
		Optional<Lancamento> obj = repo.findById(_id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				String.format("Objeto não encontrado. Id: %s, Tipo: %s.", _id, Lancamento.class.getName())));
	}

	public List<Lancamento> findByPessoa(Pessoa _pessoa) {
		List<Lancamento> obj = repo.findByPessoa(_pessoa);
		
		return obj;
	}
}
