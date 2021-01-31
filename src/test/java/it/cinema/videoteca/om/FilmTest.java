package it.cinema.videoteca.om;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FilmTest
{
	@Test
	public void costruttoreVuotoTest()
	{
		Film film = new Film();
		
		assertNotNull(film);
		assertTrue(film.getRegia().isEmpty());
		assertTrue(film.getCast().isEmpty());
	}
	
	@Test
	public void costruttoreTest()
	{
		Film film = new Film("Titolo");
		
		assertNotNull(film);
		assertEquals("Titolo", film.getTitolo());
		assertTrue(film.getRegia().isEmpty());
		assertTrue(film.getRegia().isEmpty());
	}
	
	@Test
	public void setterGetterTest()
	{
		Film film = new Film();
		film.setTitolo("Titolo");
		film.setAnno(2020);
		film.setGenere("Genere");
		
		List<Attore> cast = new ArrayList<>();
		Attore attore = new Attore("Mario", "Rossi");
		cast.add(attore);
		film.setCast(cast);
		
		List<Regista> regia = new ArrayList<>();
		Regista regista = new Regista("Giuseppe", "Verdi");
		regia.add(regista);
		film.setRegia(regia);
		
		assertEquals("Titolo", film.getTitolo());
		assertEquals(2020, film.getAnno());
		assertEquals("Genere", film.getGenere());
		assertFalse(film.getRegia().isEmpty());
		assertFalse(film.getCast().isEmpty());
	}
	
	@Test
	public void toStringTest()
	{
		Film film = new Film();
		film.setTitolo("Titolo");
		film.setAnno(2020);
		film.setGenere("Genere");
		
		List<Attore> cast = new ArrayList<>();
		Attore attore = new Attore("Mario", "Rossi");
		cast.add(attore);
		film.setCast(cast);
		
		List<Regista> regia = new ArrayList<>();
		Regista regista = new Regista("Giuseppe", "Verdi");
		regia.add(regista);
		film.setRegia(regia);
		
		assertNotNull(film);
		assertNotNull(film.toString());
	}
	
	@Test
	public void esisteInRegiaFalseTest()
	{
		Film film = new Film();
		Regista regista = new Regista("Giuseppe", "Verdi");
		
		assertFalse(film.esisteInRegia(regista));
	}
	
	@Test
	public void esisteInRegiaTrueTest()
	{
		Film film = new Film();
		
		List<Regista> regia = new ArrayList<>();
		Regista regista = new Regista("Giuseppe", "Verdi");
		regia.add(regista);
		film.setRegia(regia);
		
		Regista target = new Regista("Giuseppe", "Verdi");
		
		assertTrue(film.esisteInRegia(target));
	}
	
	@Test
	public void esisteInCastFalseTest()
	{
		Film film = new Film();
		Attore attore = new Attore("Giuseppe", "Verdi");
		
		assertFalse(film.esisteInCast(attore));
	}
	
	@Test
	public void esisteInCastTrueTest()
	{
		Film film = new Film();
		
		List<Attore> cast = new ArrayList<>();
		Attore attore = new Attore("Giuseppe", "Verdi");
		cast.add(attore);
		film.setCast(cast);
		
		Attore target = new Attore("Giuseppe", "Verdi");
		
		assertTrue(film.esisteInCast(target));
	}
	
	@Test
	public void aggiungiRegistaTest()
	{
		Film film = new Film();
		Regista regista = new Regista("Giuseppe", "Verdi");
		
		assertTrue(film.aggiungiRegista(regista));
		assertFalse(film.aggiungiRegista(regista));
	}
	
	@Test
	public void aggiungiAttoreTest()
	{
		Film film = new Film();
		Attore attore = new Attore("Giuseppe", "Verdi");
		
		assertTrue(film.aggiungiAttore(attore));
		assertFalse(film.aggiungiAttore(attore));
	}
	
	@Test
	public void rimuoviRegistaTest()
	{
		Film film = new Film();
		Regista regista = new Regista("Giuseppe", "Verdi");
		
		assertTrue(film.aggiungiRegista(regista));
		assertTrue(film.rimuoviRegista(regista));
		assertFalse(film.rimuoviRegista(regista));
	}
	
	@Test
	public void rimuoviAttoreTest()
	{
		Film film = new Film();
		Attore attore = new Attore("Giuseppe", "Verdi");
		
		assertTrue(film.aggiungiAttore(attore));
		assertTrue(film.rimuoviAttore(attore));
		assertFalse(film.rimuoviAttore(attore));
	}
	
	@Test
	public void compareToUgualiTest()
	{
		Film film1 = new Film();
		film1.setTitolo("Titolo");
		film1.setAnno(2020);
		film1.setGenere("Genere");
		
		Film film2 = new Film();
		film2.setTitolo("Titolo");
		film2.setAnno(2020);
		film2.setGenere("Genere");
		
		assertEquals(0, film1.compareTo(film2));
	}
	
	@Test
	public void compareToDiversiTitoliTest()
	{
		Film film1 = new Film();
		film1.setTitolo("Titolo1");
		film1.setAnno(2020);
		film1.setGenere("Genere");
		
		Film film2 = new Film();
		film2.setTitolo("Titolo2");
		film2.setAnno(2020);
		film2.setGenere("Genere");
		
		assertEquals(-1, film1.compareTo(film2));
		assertEquals(1, film2.compareTo(film1));
	}
	
	@Test
	public void compareToDiversiAnniTest()
	{
		Film film1 = new Film();
		film1.setTitolo("Titolo");
		film1.setAnno(2019);
		film1.setGenere("Genere");
		
		Film film2 = new Film();
		film2.setTitolo("Titolo");
		film2.setAnno(2020);
		film2.setGenere("Genere");
		
		assertEquals(-1, film1.compareTo(film2));
		assertEquals(1, film2.compareTo(film1));
	}
	
	@Test
	public void equalsTrueTest()
	{
		Film film1 = new Film();
		film1.setTitolo("Titolo");
		film1.setAnno(2020);
		film1.setGenere("Genere");
		
		Film film2 = new Film();
		film2.setTitolo("Titolo");
		film2.setAnno(2020);
		film2.setGenere("Genere");
		
		assertTrue(film1.equals(film2));
	}
}
