package it.cinema.videoteca.om;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

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
		attore.setDataNascita(new DateTime(1991, 10, 13, 0, 0));
		attore.setDataMorte(new DateTime(2021, 1, 31, 0, 0));
		attore.setFilmografia(new ArrayList<>());
		
		assertEquals("La Potta, Amedeo", attore.getIdNome());
		assertEquals("Amedeo", attore.getNome());
		assertEquals("La Potta", attore.getCognome());
		assertEquals(new DateTime(1991, 10, 13, 0, 0), attore.getDataNascita());
		assertEquals(new DateTime(2021, 1, 31, 0, 0), attore.getDataMorte());
		assertTrue(attore.getFilmografia().isEmpty());
	}
	
	@Test
	public void compareToTest()
	{
		Attore attore1 = new Attore();
		attore1.setIdNome("La Potta, Amedeo");
		attore1.setNome("Amedeo");
		attore1.setCognome("La Potta");
		attore1.setDataNascita(new DateTime(1991, 10, 13, 0, 0));
		attore1.setDataMorte(new DateTime(2021, 1, 31, 0, 0));
		attore1.setFilmografia(new ArrayList<>());
		
		Attore attore2 = new Attore();
		attore2.setIdNome("La Potta, Amedeo");
		attore2.setNome("Amedeo");
		attore2.setCognome("La Potta");
		attore2.setDataNascita(new DateTime(1991, 10, 13, 0, 0));
		attore2.setDataMorte(new DateTime(2021, 1, 31, 0, 0));
		attore2.setFilmografia(new ArrayList<>());
		
		assertEquals(0, attore1.compareTo(attore2));
		
		Attore attore3 = new Attore();
		attore3.setIdNome("Mosca, Maurizio");
		attore3.setNome("Maurizio");
		attore3.setCognome("Mosca");
		attore3.setDataNascita(new DateTime(1950, 10, 13, 0, 0));
		attore3.setDataMorte(new DateTime(2006, 1, 31, 0, 0));
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
		attore1.setDataNascita(new DateTime(1991, 10, 13, 0, 0));
		attore1.setDataMorte(new DateTime(2021, 1, 31, 0, 0));
		attore1.setFilmografia(new ArrayList<>());
		
		assertFalse(attore1.equals(null));
		
		Attore attore2 = attore1;
		
		assertTrue(attore1.equals(attore2));
		
		Attore attore3 = new Attore();
		attore3.setIdNome("La Potta, Amedeo");
		attore3.setNome("Amedeo");
		attore3.setCognome("La Potta");
		attore3.setDataNascita(new DateTime(1991, 10, 13, 0, 0));
		attore3.setDataMorte(new DateTime(2021, 1, 31, 0, 0));
		attore3.setFilmografia(new ArrayList<>());
		
		assertTrue(attore1.equals(attore3));
	}
	
	@Test
	public void toStringTest()
	{
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		attore.setNome("Amedeo");
		attore.setCognome("La Potta");
		attore.setDataNascita(new DateTime(1991, 10, 13, 0, 0));
		attore.setDataMorte(new DateTime(2021, 1, 31, 0, 0));
		attore.setFilmografia(new ArrayList<>());
		
		assertNotNull(attore.toString());
	}
}
