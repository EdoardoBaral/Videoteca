package it.cinema.videoteca.om;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AttoreTest
{
	@Test
	public void costruttoreVuotoTest()
	{
		Attore attore = new Attore();
		
		assertNotNull(attore);
		assertTrue(attore.getFilmografia().isEmpty());
	}
	
	@Test
	public void costruttoreTest()
	{
		Attore attore = new Attore("Amedeo", "La Potta");
		
		assertNotNull(attore);
		assertEquals("Amedeo", attore.getNome());
		assertEquals("La Potta", attore.getCognome());
	}
	
	@Test
	public void setterGetterTest()
	{
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		attore.setNome("Amedeo");
		attore.setCognome("La Potta");
		attore.setDataNascita(LocalDate.of(1991, 10, 13));
		attore.setDataMorte(LocalDate.of(2021, 1, 31));
		attore.setFilmografia(new ArrayList<>());
		
		assertEquals("La Potta, Amedeo", attore.getIdNome());
		assertEquals("Amedeo", attore.getNome());
		assertEquals("La Potta", attore.getCognome());
		assertEquals(LocalDate.of(1991, 10, 13), attore.getDataNascita());
		assertEquals(LocalDate.of(2021, 1, 31), attore.getDataMorte());
		assertTrue(attore.getFilmografia().isEmpty());
	}
	
	@Test
	public void compareToTest()
	{
		Attore attore1 = new Attore();
		attore1.setIdNome("La Potta, Amedeo");
		attore1.setNome("Amedeo");
		attore1.setCognome("La Potta");
		attore1.setDataNascita(LocalDate.of(1991, 10, 13));
		attore1.setDataMorte(LocalDate.of(2021, 1, 31));
		attore1.setFilmografia(new ArrayList<>());
		
		Attore attore2 = new Attore();
		attore2.setIdNome("La Potta, Amedeo");
		attore2.setNome("Amedeo");
		attore2.setCognome("La Potta");
		attore2.setDataNascita(LocalDate.of(1991, 10, 13));
		attore2.setDataMorte(LocalDate.of(2021, 1, 31));
		attore2.setFilmografia(new ArrayList<>());
		
		assertEquals(0, attore1.compareTo(attore2));
		
		Attore attore3 = new Attore();
		attore3.setIdNome("Mosca, Maurizio");
		attore3.setNome("Maurizio");
		attore3.setCognome("Mosca");
		attore3.setDataNascita(LocalDate.of(1950, 10, 13));
		attore3.setDataMorte(LocalDate.of(2006, 1, 31));
		attore3.setFilmografia(new ArrayList<>());
		
		assertEquals(-1, attore1.compareTo(attore3));
		assertEquals(1, attore3.compareTo(attore2));
	}
	
	@Test
	public void equalsTest()
	{
		Attore attore1 = new Attore();
		attore1.setIdNome("La Potta, Amedeo");
		attore1.setNome("Amedeo");
		attore1.setCognome("La Potta");
		attore1.setDataNascita(LocalDate.of(1991, 10, 13));
		attore1.setDataMorte(LocalDate.of(2021, 1, 31));
		attore1.setFilmografia(new ArrayList<>());
		
		assertFalse(attore1.equals(null));
		
		Attore attore2 = attore1;
		
		assertTrue(attore1.equals(attore2));
		
		Attore attore3 = new Attore();
		attore3.setIdNome("La Potta, Amedeo");
		attore3.setNome("Amedeo");
		attore3.setCognome("La Potta");
		attore3.setDataNascita(LocalDate.of(1991, 10, 13));
		attore3.setDataMorte(LocalDate.of(2021, 1, 31));
		attore3.setFilmografia(new ArrayList<>());
		
		assertTrue(attore1.equals(attore3));
	}
	
	@Test
	public void esisteInFilmografiaFalseTest()
	{
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		attore.setNome("Amedeo");
		attore.setCognome("La Potta");
		attore.setDataNascita(LocalDate.of(1991, 10, 13));
		attore.setDataMorte(LocalDate.of(2021, 1, 31));
		
		boolean result = attore.esisteInFilmografia(new Film("Il test"));
		assertFalse(result);
	}
	
	@Test
	public void esisteInFilmografiaTrueTest()
	{
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		attore.setNome("Amedeo");
		attore.setCognome("La Potta");
		attore.setDataNascita(LocalDate.of(1991, 10, 13));
		attore.setDataMorte(LocalDate.of(2021, 1, 31));
		
		Film film = new Film("Il test");
		attore.aggiungiFilm(film);
		
		boolean result = attore.esisteInFilmografia(film);
		assertTrue(result);
	}
	
	@Test
	public void aggiungiFilmTest()
	{
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		attore.setNome("Amedeo");
		attore.setCognome("La Potta");
		attore.setDataNascita(LocalDate.of(1991, 10, 13));
		attore.setDataMorte(LocalDate.of(2021, 1, 31));
		
		boolean result = attore.aggiungiFilm(new Film("Il test"));
		assertTrue(result);
	}
	
	@Test
	public void aggiungiFilmFalseTest()
	{
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		attore.setNome("Amedeo");
		attore.setCognome("La Potta");
		attore.setDataNascita(LocalDate.of(1991, 10, 13));
		attore.setDataMorte(LocalDate.of(2021, 1, 31));
		
		attore.aggiungiFilm(new Film("Il test"));
		
		boolean result = attore.aggiungiFilm(new Film("Il test"));
		assertFalse(result);
	}
	
	@Test
	public void rimuoviFilmFalseTest()
	{
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		attore.setNome("Amedeo");
		attore.setCognome("La Potta");
		attore.setDataNascita(LocalDate.of(1991, 10, 13));
		attore.setDataMorte(LocalDate.of(2021, 1, 31));
		
		boolean result = attore.rimuoviFilm(new Film("Il test"));
		assertFalse(result);
	}
	
	@Test
	public void rimuoviFilmTest()
	{
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		attore.setNome("Amedeo");
		attore.setCognome("La Potta");
		attore.setDataNascita(LocalDate.of(1991, 10, 13));
		attore.setDataMorte(LocalDate.of(2021, 1, 31));
		
		Film film = new Film("Il test");
		attore.aggiungiFilm(film);
		
		boolean result = attore.rimuoviFilm(film);
		assertTrue(result);
	}
	
	@Test
	public void rimuoviFilmFalseTest_2()
	{
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		attore.setNome("Amedeo");
		attore.setCognome("La Potta");
		attore.setDataNascita(LocalDate.of(1991, 10, 13));
		attore.setDataMorte(LocalDate.of(2021, 1, 31));
		
		boolean result = attore.rimuoviFilm("Il test");
		assertFalse(result);
	}
	
	@Test
	public void rimuoviFilmTest_2()
	{
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		attore.setNome("Amedeo");
		attore.setCognome("La Potta");
		attore.setDataNascita(LocalDate.of(1991, 10, 13));
		attore.setDataMorte(LocalDate.of(2021, 1, 31));
		
		attore.aggiungiFilm(new Film("Il test"));
		
		boolean result = attore.rimuoviFilm("Il test");
		assertTrue(result);
	}
	
	@Test
	public void toStringTest()
	{
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		attore.setNome("Amedeo");
		attore.setCognome("La Potta");
		attore.setDataNascita(LocalDate.of(1991, 10, 13));
		attore.setDataMorte(LocalDate.of(2021, 1, 31));
		attore.setFilmografia(new ArrayList<>());
		
		assertNotNull(attore.toString());
	}
}
