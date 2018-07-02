package br.com.hsj.macapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hsj.macapi.domain.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Integer> {

}
