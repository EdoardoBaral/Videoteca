package it.cinema.videoteca.connector.regista;

import it.cinema.videoteca.connector.regista.RegistaConnector;
import it.cinema.videoteca.om.Regista;
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
public class RegistaJpaConnectorTest
{
	@Autowired
	private RegistaConnector connector;
	
	@Test
	public void aggiungiRegistaTest()
	{
		Regista regista = new Regista();
		regista.setIdNome("La Potta, Amedeo");
		regista.setNome("Amedeo");
		regista.setCognome("La Potta");
		regista.setDataNascita(LocalDate.of(1991, 10, 13));
		
		Regista result = connector.aggiungiRegista(regista);
		assertNotNull(result);
		assertEquals("La Potta, Amedeo", result.getIdNome());
	}
	
	@Test
	public void rimuoviRegistaInesistenteTest_1()
	{
		Regista result = connector.rimuoviRegista("Pallo, Pinco");
		assertNull(result);
	}
	
	@Test
	public void rimuoviRegistaInesistenteTest_2()
	{
		Regista regista = new Regista("Pinco", "Pallo");
		
		Regista result = connector.rimuoviRegista(regista);
		assertNull(result);
	}
	
	@Test
	public void rimuoviRegistaTest_1()
	{
		Regista regista = new Regista();
		regista.setIdNome("La Potta, Amedeo");
		regista.setNome("Amedeo");
		regista.setCognome("La Potta");
		regista.setDataNascita(LocalDate.of(1991, 10, 13));
		connector.aggiungiRegista(regista);
		
		Regista result = connector.rimuoviRegista(regista);
		assertNotNull(result);
		assertEquals("La Potta, Amedeo", result.getIdNome());
	}
	
	@Test
	public void rimuoviRegistaTest_2()
	{
		Regista regista = new Regista();
		regista.setIdNome("La Potta, Amedeo");
		regista.setNome("Amedeo");
		regista.setCognome("La Potta");
		regista.setDataNascita(LocalDate.of(1991, 10, 13));
		connector.aggiungiRegista(regista);
		
		Regista result = connector.rimuoviRegista(regista.getIdNome());
		assertNotNull(result);
		assertEquals("La Potta, Amedeo", result.getIdNome());
	}
	
	@Test
	public void aggiornaRegistaTest()
	{
		Regista regista = new Regista();
		regista.setIdNome("La Potta, Amedeo");
		regista.setNome("Amedeo");
		regista.setCognome("La Potta");
		regista.setDataNascita(LocalDate.of(1991, 10, 13));
		connector.aggiungiRegista(regista);
		
		regista.setDataMorte(LocalDate.of(2021, 3, 6));
		Regista result = connector.aggiornaRegista(regista);
		assertNotNull(result);
		assertEquals(LocalDate.of(2021, 3, 6), result.getDataMorte());
	}
	
	@Test
	public void cercaRegistaPerIdNomeInesistenteTest()
	{
		Regista result = connector.cercaRegistaPerIdNome("Pallo, Pinco");
		assertNull(result);
	}
	
	@Test
	public void cercaRegistaPerIdNomeTest()
	{
		Regista regista = new Regista();
		regista.setIdNome("La Potta, Amedeo");
		regista.setNome("Amedeo");
		regista.setCognome("La Potta");
		regista.setDataNascita(LocalDate.of(1991, 10, 13));
		connector.aggiungiRegista(regista);
		
		Regista result = connector.cercaRegistaPerIdNome("La Potta, Amedeo");
		assertNotNull(result);
		assertEquals("La Potta, Amedeo", result.getIdNome());
	}
	
	@Test
	public void cercaRegistiPerNomeInesistenteTest()
	{
		List<Regista> result = connector.cercaRegistiPerNome("Ugo");
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void cercaRegistiPerNomeTest()
	{
		Regista regista = new Regista();
		regista.setIdNome("La Potta, Amedeo");
		regista.setNome("Amedeo");
		regista.setCognome("La Potta");
		regista.setDataNascita(LocalDate.of(1991, 10, 13));
		connector.aggiungiRegista(regista);
		
		List<Regista> result = connector.cercaRegistiPerNome("Amedeo");
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}
	
	@Test
	public void cercaRegistiPerCognomeInesistenteTest()
	{
		List<Regista> result = connector.cercaRegistiPerCognome("Rossi");
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void cercaRegistiPerCognomeTest()
	{
		Regista regista = new Regista();
		regista.setIdNome("La Potta, Amedeo");
		regista.setNome("Amedeo");
		regista.setCognome("La Potta");
		regista.setDataNascita(LocalDate.of(1991, 10, 13));
		connector.aggiungiRegista(regista);
		
		List<Regista> result = connector.cercaRegistiPerCognome("La Potta");
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}
}
