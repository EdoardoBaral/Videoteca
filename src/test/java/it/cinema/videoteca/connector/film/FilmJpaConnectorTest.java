package it.cinema.videoteca.connector.film;

import it.cinema.videoteca.om.Attore;
import it.cinema.videoteca.om.Film;
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
public class FilmJpaConnectorTest
{
	@Autowired
	private FilmConnector connector;
	
	@Test
	public void aggiungiFilmSenzaRegiaCastTest()
	{
		Film film = createFilmSenzaRegiaCast();
		Film result = connector.aggiungiFilm(film);

		assertNotNull(result);
		assertTrue(film.equals(result));
	}
	
	private Film createFilmSenzaRegiaCast()
	{
		Film film = new Film();
		film.setTitolo("Film Test 01");
		film.setGenere("Test");
		film.setAnno(2021);
		
		return film;
	}
	
	@Test
	public void aggiungiFilmTest()
	{
		Film film = createFilm();
		Film result = connector.aggiungiFilm(film);
		
		assertNotNull(result);
		assertTrue(film.equals(result));
	}
	
	private Film createFilm()
	{
		Film film = new Film();
		film.setTitolo("Film Test 01");
		film.setGenere("Test");
		film.setAnno(2021);
		
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		attore.setNome("Amedeo");
		attore.setCognome("La Potta");
		attore.setDataNascita(LocalDate.now());
		attore.aggiungiFilm(film);
		
		film.aggiungiAttore(attore);

		Regista regista = new Regista();
		regista.setIdNome("Fantozzi, Ugo");
		regista.setNome("Ugo");
		regista.setCognome("Fantozzi");
		regista.setDataNascita(LocalDate.now());
		regista.aggiungiFilm(film);

		film.aggiungiRegista(regista);
		
		return film;
	}
	
	@Test
	public void rimuoviFilmTestFalse()
	{
		Film result = connector.rimuoviFilm("Prova");
		assertNull(result);
	}
	
	@Test
	public void rimuoviFilmTestTrue()
	{
		Film film = createFilm();
		connector.aggiungiFilm(film);
		
		Film result = connector.rimuoviFilm("Film Test 01");
		
		assertNotNull(result);
		assertEquals("Film Test 01", result.getTitolo());
	}
	
	@Test
	public void aggiornaFilmTest()
	{
		Film film = createFilm();
		connector.aggiungiFilm(film);
		
		film.setGenere("Drammatico");
		film.setAnno(1980);
		
		Film result = connector.aggiornaFilm(film);
		
		assertNotNull(result);
		assertEquals("Drammatico", result.getGenere());
		assertEquals(1980, film.getAnno());
	}
	
	@Test
	public void cercaFilmPerTitoloTestFalse()
	{
		Film film = new Film("Titolo 1");
		connector.aggiungiFilm(film);
		
		Film result = connector.cercaFilmPerTitolo("Prova");
		
		assertNull(result);
	}
	
	@Test
	public void cercaFilmPerTitoloTestTrue()
	{
		Film f1 = new Film("Titolo 1");
		connector.aggiungiFilm(f1);
		Film f2 = new Film("Titolo 2");
		connector.aggiungiFilm(f2);
		
		Film result = connector.cercaFilmPerTitolo("Titolo 2");
		
		assertNotNull(result);
		assertEquals("Titolo 2", result.getTitolo());
	}
	
	@Test
	public void cercaFilmPerRegistaTestFalse()
	{
		Film film = createFilm();
		connector.aggiungiFilm(film);
		Regista regista = new Regista();
		regista.setIdNome("Cioni, Pierugo");
		
		List<Film> result = connector.cercaFilmPerRegista(regista);
		
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void cercaFilmPerRegistaTestTrue()
	{
		Film film = createFilm();
		connector.aggiungiFilm(film);
		Regista regista = new Regista();
		regista.setIdNome("Fantozzi, Ugo");
		
		List<Film> result = connector.cercaFilmPerRegista(regista);
		
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertEquals(1, result.size());
		assertEquals("Film Test 01", result.get(0).getTitolo());
	}
	
	@Test
	public void cercaFilmPerAttoreTestFalse()
	{
		Film film = createFilm();
		connector.aggiungiFilm(film);
		Attore attore = new Attore();
		attore.setIdNome("Cioni, Pierugo");
		
		List<Film> result = connector.cercaFilmPerAttore(attore);
		
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void cercaFilmPerAttoreTestTrue()
	{
		Film film = createFilm();
		connector.aggiungiFilm(film);
		Attore attore = new Attore();
		attore.setIdNome("La Potta, Amedeo");
		
		List<Film> result = connector.cercaFilmPerAttore(attore);
		
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertEquals(1, result.size());
		assertEquals("Film Test 01", result.get(0).getTitolo());
	}
	
	@Test
	public void cercaFilmPerGenereTestFalse()
	{
		Film film = createFilm();
		connector.aggiungiFilm(film);
		
		List<Film> result = connector.cercaFilmPerGenere("Cinecomic");
		
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void cercaFilmPerGenereTestTrue()
	{
		Film film = createFilm();
		connector.aggiungiFilm(film);
		
		List<Film> result = connector.cercaFilmPerGenere("Test");
		
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertEquals("Film Test 01", result.get(0).getTitolo());
	}
	
	@Test
	public void cercaFilmPerAnnoTestFalse()
	{
		Film film = createFilm();
		connector.aggiungiFilm(film);
		
		List<Film> result = connector.cercaFilmPerAnno(2006);
		
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void cercaFilmPerAnnoTestTrue()
	{
		Film film = createFilm();
		connector.aggiungiFilm(film);
		
		List<Film> result = connector.cercaFilmPerAnno(2021);
		
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertEquals("Film Test 01", result.get(0).getTitolo());
	}
	
	@Test
	public void cercaTuttiFilmTest()
	{
		Film film = createFilm();
		connector.aggiungiFilm(film);
		
		List<Film> result = connector.cercaTuttiFilm();
		
		assertNotNull(result);
		assertFalse(result.isEmpty());
		assertEquals(1, result.size());
	}
}
