package br.com.hsj.macapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hsj.macapi.domain.Lancamento;
import br.com.hsj.macapi.domain.Pessoa;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Integer>{

	public List<Lancamento> findByPessoa(Pessoa _pessoa);
	
}
