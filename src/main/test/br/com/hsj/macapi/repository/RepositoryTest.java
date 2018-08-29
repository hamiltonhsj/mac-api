package br.com.hsj.macapi.repository;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

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
    
    @Test
    public void criarEndereco() {
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
    	
    	entityManager.persist(endereco);
    	entityManager.flush();
    	
    	List<Endereco> retorno = enderecoRepository.findByLogradouro("Teste 123");
    	
    	assertTrue(!retorno.isEmpty());
    	
    }
    
}
