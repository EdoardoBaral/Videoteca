package it.cinema.videoteca.om;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RegistaTest
{
	@Test
	public void costruttoreVuotoTest()
	{
		Regista regista = new Regista();
		
		assertNotNull(regista);
		assertTrue(regista.getFilmografia().isEmpty());
	}
	
	@Test
	public void costruttoreTest()
	{
		Regista regista = new Regista("Amedeo", "La Potta");
		
		assertNotNull(regista);
		assertEquals("Amedeo", regista.getNome());
		assertEquals("La Potta", regista.getCognome());
	}
	
	@Test
	public void setterGetterTest()
	{
		Regista regista = new Regista();
		regista.setIdNome("La Potta, Amedeo");
		regista.setNome("Amedeo");
		regista.setCognome("La Potta");
		regista.setDataNascita(LocalDate.of(1991, 10, 13));
		regista.setDataMorte(LocalDate.of(2021, 1, 31));
		regista.setFilmografia(new ArrayList<>());
		
		assertEquals("La Potta, Amedeo", regista.getIdNome());
		assertEquals("Amedeo", regista.getNome());
		assertEquals("La Potta", regista.getCognome());
		assertEquals(LocalDate.of(1991, 10, 13), regista.getDataNascita());
		assertEquals(LocalDate.of(2021, 1, 31), regista.getDataMorte());
		assertTrue(regista.getFilmografia().isEmpty());
	}
	
	@Test
	public void compareToTest()
	{
		Regista regista1 = new Regista();
		regista1.setIdNome("La Potta, Amedeo");
		regista1.setNome("Amedeo");
		regista1.setCognome("La Potta");
		regista1.setDataNascita(LocalDate.of(1991, 10, 13));
		regista1.setDataMorte(LocalDate.of(2021, 1, 31));
		regista1.setFilmografia(new ArrayList<>());
		
		Regista regista2 = new Regista();
		regista2.setIdNome("La Potta, Amedeo");
		regista2.setNome("Amedeo");
		regista2.setCognome("La Potta");
		regista2.setDataNascita(LocalDate.of(1991, 10, 13));
		regista2.setDataMorte(LocalDate.of(2021, 1, 31));
		regista2.setFilmografia(new ArrayList<>());
		
		assertEquals(0, regista1.compareTo(regista2));
		
		Regista regista3 = new Regista();
		regista3.setIdNome("Mosca, Maurizio");
		regista3.setNome("Maurizio");
		regista3.setCognome("Mosca");
		regista3.setDataNascita(LocalDate.of(1950, 10, 13));
		regista3.setDataMorte(LocalDate.of(2006, 1, 31));
		regista3.setFilmografia(new ArrayList<>());
		
		assertEquals(-1, regista1.compareTo(regista3));
		assertEquals(1, regista3.compareTo(regista2));
	}
	
	@Test
	public void equalsTest()
	{
		Regista regista1 = new Regista();
		regista1.setIdNome("La Potta, Amedeo");
		regista1.setNome("Amedeo");
		regista1.setCognome("La Potta");
		regista1.setDataNascita(LocalDate.of(1991, 10, 13));
		regista1.setDataMorte(LocalDate.of(2021, 1, 31));
		regista1.setFilmografia(new ArrayList<>());
		
		assertFalse(regista1.equals(null));
		
		Regista regista2 = regista1;
		
		assertTrue(regista1.equals(regista2));
		
		Regista regista3 = new Regista();
		regista3.setIdNome("La Potta, Amedeo");
		regista3.setNome("Amedeo");
		regista3.setCognome("La Potta");
		regista3.setDataNascita(LocalDate.of(1991, 10, 13));
		regista3.setDataMorte(LocalDate.of(2021, 1, 31));
		regista3.setFilmografia(new ArrayList<>());
		
		assertTrue(regista1.equals(regista3));
	}
	
	@Test
	public void toStringTest()
	{
		Regista regista = new Regista();
		regista.setIdNome("La Potta, Amedeo");
		regista.setNome("Amedeo");
		regista.setCognome("La Potta");
		regista.setDataNascita(LocalDate.of(1991, 10, 13));
		regista.setDataMorte(LocalDate.of(2021, 1, 31));
		regista.setFilmografia(new ArrayList<>());
		
		assertNotNull(regista.toString());
	}
}
