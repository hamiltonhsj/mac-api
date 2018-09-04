package br.com.hsj.macapi.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.hsj.macapi.domain.Auditoria;
import br.com.hsj.macapi.domain.Endereco;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private LojaRepository lojaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;
    
    @Before
    public void setUp() {
    	criarEnderecos();
    }
    
    public void criarEnderecos() {
    	Endereco endereco = new Endereco();
    	endereco.setTipo("Rua");
    	endereco.setLogradouro("Teste 123");
    	endereco.setNumero(123);
    	endereco.setComplemento("Complemento 123");
    	endereco.setBairro("Bairro 123");
    	endereco.setCidade("Cidade 123");
    	endereco.setEstado("Estado 123");
    	endereco.setCep("80050470");
    	
    	Auditoria auditoria = new Auditoria();
    	auditoria.setCriadoEm(LocalDateTime.now());
    	auditoria.setCriadoPor("teste");
    	
    	endereco.setAuditoria(auditoria);
    	
    	enderecoRepository.save(endereco);
    	
    	endereco = new Endereco();
    	endereco.setTipo("Rua");
    	endereco.setLogradouro("Teste 1234");
    	endereco.setNumero(123);
    	endereco.setComplemento("Complemento 1234");
    	endereco.setBairro("Bairro 1234");
    	endereco.setCidade("Cidade 1234");
    	endereco.setEstado("Estado 1234");
    	endereco.setCep("80040120");
    	
    	auditoria = new Auditoria();
    	auditoria.setCriadoEm(LocalDateTime.now());
    	auditoria.setCriadoPor("teste 2");
    	
    	endereco.setAuditoria(auditoria);
    	
    	enderecoRepository.save(endereco);
    	
    }
    
    @Test
    public void endereco_findByLogradouro() {
    	List<Endereco> retorno = enderecoRepository.findByLogradouro("Teste 123");
    	List<Endereco> retorno2 = enderecoRepository.findByLogradouro("Teste 1234");
    	
    	assertFalse(retorno.isEmpty());
    	assertFalse(retorno2.isEmpty());
    	assertEquals("Teste 123", retorno.get(0).getLogradouro());
    	assertEquals("Teste 1234", retorno2.get(0).getLogradouro());
    }

    @Test
    public void endereco_findByCep() {
    	List<Endereco> retorno = enderecoRepository.findByCep("80050470");
    	List<Endereco> retorno2 = enderecoRepository.findByCep("80040120");
    	
    	assertFalse(retorno.isEmpty());
    	assertFalse(retorno2.isEmpty());
    	assertEquals("Teste 123", retorno.get(0).getLogradouro());
    	assertEquals("Teste 1234", retorno2.get(0).getLogradouro());
    }
    
}
