package br.com.als.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.als.model.Ordem;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class OrdemRepositoryTest {
	
	@InjectMock
	OrdemRespository ordemRespository;
	
	@Test
	public void testarSeListAllRetornaOrdensCorretas() {
		Ordem primeiraOrdem = new Ordem();
		Ordem segundaOrdem = new Ordem();
		
		List<Ordem> ordens = new ArrayList<Ordem>();
		
		ordens.add(primeiraOrdem);
		ordens.add(segundaOrdem);
		
		Mockito.when(ordemRespository.listAll()).thenReturn(ordens);
		
		Assertions.assertSame(segundaOrdem, ordemRespository.listAll().get(1));
	}

}
