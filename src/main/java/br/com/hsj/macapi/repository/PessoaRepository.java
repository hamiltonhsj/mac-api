package br.com.hsj.macapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hsj.macapi.domain.Loja;
import br.com.hsj.macapi.domain.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	public List<Pessoa> findByLoja(Loja _loja);
}
