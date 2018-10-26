package br.com.hsj.macapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.hsj.macapi.domain.TipoLancamento;
import br.com.hsj.macapi.exception.BusinessException;
import br.com.hsj.macapi.exception.ObjectNotFoundException;
import br.com.hsj.macapi.repository.TipoLancamentoRespository;

@Service
public class TipoLancamentoService {

	
	@Autowired
	private TipoLancamentoRespository repo;
	
	public List<TipoLancamento> findAll() {
		return repo.findAll();

	}
	
	public TipoLancamento save(TipoLancamento _tipoLancamento) throws BusinessException {
		TipoLancamento tipo = null;
		
		try {
			tipo = repo.save(_tipoLancamento);
		
		} catch (DataIntegrityViolationException e) {
			throw new BusinessException("Já existe uma tipo de lançamento cadastrado.", e);
		}
		
		return tipo;
	}
	
	public TipoLancamento find(Integer _id) {
		Optional<TipoLancamento> obj = repo.findById(_id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				String.format("Objeto não encontrado. Id: %s, Tipo: %s.", _id, TipoLancamento.class.getName())));
	}
}
