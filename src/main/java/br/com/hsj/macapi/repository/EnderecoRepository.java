package br.com.hsj.macapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hsj.macapi.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

	public List<Endereco> findByLogradouro(String _logadouro);

	public List<Endereco> findByCep(String _cep);
}
