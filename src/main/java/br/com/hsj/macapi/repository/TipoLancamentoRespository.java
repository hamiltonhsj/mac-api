package br.com.hsj.macapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hsj.macapi.domain.TipoLancamento;

public interface TipoLancamentoRespository extends JpaRepository<TipoLancamento, Integer> {

}
