package it.cinema.videoteca.connector.attore;

import it.cinema.videoteca.om.Attore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AttoreJpaConnectorTest
{
	@Autowired
	private AttoreConnector connector;
	
	@Test
	public void aggiungiAttoreTest()
	{
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		attore.setNome("Amedeo");
		attore.setCognome("La Potta");
		attore.setDataNascita(LocalDate.of(1991, 10, 13));
		
		Attore result = connector.aggiungiAttore(attore);
		assertNotNull(result);
		assertEquals("La Potta, Amedeo", result.getIdNome());
	}
	
	@Test
	public void rimuoviAttoreInesistenteTest_1()
	{
		Attore result = connector.rimuoviAttore("Pallo, Pinco");
		assertNull(result);
	}
	
	@Test
	public void rimuoviAttoreInesistenteTest_2()
	{
		Attore attore = new Attore("Pinco", "Pallo");
		
		Attore result = connector.rimuoviAttore(attore);
		assertNull(result);
	}
	
	@Test
	public void rimuoviAttoreTest_1()
	{
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		attore.setNome("Amedeo");
		attore.setCognome("La Potta");
		attore.setDataNascita(LocalDate.of(1991, 10, 13));
		connector.aggiungiAttore(attore);
		
		Attore result = connector.rimuoviAttore(attore);
		assertNotNull(result);
		assertEquals("La Potta, Amedeo", result.getIdNome());
	}
	
	@Test
	public void rimuoviAttoreTest_2()
	{
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		attore.setNome("Amedeo");
		attore.setCognome("La Potta");
		attore.setDataNascita(LocalDate.of(1991, 10, 13));
		connector.aggiungiAttore(attore);
		
		Attore result = connector.rimuoviAttore(attore.getIdNome());
		assertNotNull(result);
		assertEquals("La Potta, Amedeo", result.getIdNome());
	}
	
	@Test
	public void aggiornaAttoreTest()
	{
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		attore.setNome("Amedeo");
		attore.setCognome("La Potta");
		attore.setDataNascita(LocalDate.of(1991, 10, 13));
		connector.aggiungiAttore(attore);
		
		attore.setDataMorte(LocalDate.of(2021, 3, 6));
		Attore result = connector.aggiornaAttore(attore);
		assertNotNull(result);
		assertEquals(LocalDate.of(2021, 3, 6), result.getDataMorte());
	}
	
	@Test
	public void cercaAttorePerIdNomeInesistenteTest()
	{
		Attore result = connector.cercaAttorePerIdNome("Pallo, Pinco");
		assertNull(result);
	}
	
	@Test
	public void cercaAttorePerIdNomeTest()
	{
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		attore.setNome("Amedeo");
		attore.setCognome("La Potta");
		attore.setDataNascita(LocalDate.of(1991, 10, 13));
		connector.aggiungiAttore(attore);
		
		Attore result = connector.cercaAttorePerIdNome("La Potta, Amedeo");
		assertNotNull(result);
		assertEquals("La Potta, Amedeo", result.getIdNome());
	}
	
	@Test
	public void cercaAttoriPerNomeInesistenteTest()
	{
		List<Attore> result = connector.cercaAttoriPerNome("Ugo");
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void cercaAttoriPerNomeTest()
	{
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		attore.setNome("Amedeo");
		attore.setCognome("La Potta");
		attore.setDataNascita(LocalDate.of(1991, 10, 13));
		connector.aggiungiAttore(attore);
		
		List<Attore> result = connector.cercaAttoriPerNome("Amedeo");
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}
	
	@Test
	public void cercaAttoriPerCognomeInesistenteTest()
	{
		List<Attore> result = connector.cercaAttoriPerCognome("Rossi");
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void cercaAttoriPerCognomeTest()
	{
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		attore.setNome("Amedeo");
		attore.setCognome("La Potta");
		attore.setDataNascita(LocalDate.of(1991, 10, 13));
		connector.aggiungiAttore(attore);
		
		List<Attore> result = connector.cercaAttoriPerCognome("La Potta");
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}
}
