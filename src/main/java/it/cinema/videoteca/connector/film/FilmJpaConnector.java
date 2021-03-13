package it.cinema.videoteca.connector.film;

import it.cinema.videoteca.connector.attore.AttoreJpaRepository;
import it.cinema.videoteca.connector.regista.RegistaJpaRepository;
import it.cinema.videoteca.om.Attore;
import it.cinema.videoteca.om.Film;
import it.cinema.videoteca.om.Regista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmJpaConnector implements FilmConnector
{
	@Autowired
	private FilmJpaRepository filmRepository;
	
	@Autowired
	private RegistaJpaRepository registaRepository;
	
	@Autowired
	private AttoreJpaRepository attoreRepository;
	
	@Override
	public Film aggiungiFilm(Film film)
	{
		// Devo salvare una copia di Film senza cast e regia (senza legami con Attore e Regista) in modo da salvarlo sul DB come
		// entità a sè stante, prima di popolare le tabelle associative CAST e REGIA
		Film f = copiaFilm(film);
		filmRepository.save(f);
		
		for(Regista regista : film.getRegia())
		{
			// Devo creare una copia di Regista senza filmografia (senza legami con Film) in modo da salvarlo sul DB come
			// entità a sè stante, prima di popolare la tabella associativa REGIA
			Regista temp = copiaRegista(regista);
			registaRepository.save(temp);
		}
		
		for(Attore attore : film.getCast())
		{
			// Devo creare una copia di Attore senza filmografia (senza legami con Film) in modo da salvarlo sul DB come
			// entità a sè stante, prima di popolare la tabella associativa CAST
			Attore temp = copiaAttore(attore);
			attoreRepository.save(temp);
		}
		
		// A questo punto, avendo salvato le entità senza relazioni sul DB, dovrebbe essere possibile aggiornarle salvando
		// l'oggetto Film con le relazioni di cast e regia, passato come argomento al metodo
		return filmRepository.save(film);
	}
	
	private Film copiaFilm(Film film)
	{
		Film copia = new Film();
		copia.setTitolo(film.getTitolo());
		copia.setGenere(film.getGenere());
		copia.setAnno(film.getAnno());
		
		return copia;
	}
	
	private Regista copiaRegista(Regista regista)
	{
		Regista copia = new Regista();
		copia.setIdNome(regista.getIdNome());
		copia.setNome(regista.getNome());
		copia.setCognome((regista.getCognome()));
		copia.setDataNascita(regista.getDataNascita());
		copia.setDataMorte(regista.getDataMorte());
		
		return copia;
	}
	
	private Attore copiaAttore(Attore attore)
	{
		Attore copia = new Attore();
		copia.setIdNome(attore.getIdNome());
		copia.setNome(attore.getNome());
		copia.setCognome((attore.getCognome()));
		copia.setDataNascita(attore.getDataNascita());
		copia.setDataMorte(attore.getDataMorte());
		
		return copia;
	}
	
	@Override
	public Film rimuoviFilm(Film film)
	{
		Film result = filmRepository.findByTitolo(film.getTitolo());
		if(result != null)
			return result;
		else
			return null;
	}
	
	@Override
	public Film rimuoviFilm(String titolo)
	{
		Film result = filmRepository.findByTitolo(titolo);
		if(result != null)
			return result;
		else
			return null;
	}
	
	@Override
	public Film aggiornaFilm(Film film)
	{
		return filmRepository.save(film);
	}
	
	@Override
	public Film cercaFilmPerTitolo(String titolo)
	{
		return filmRepository.findByTitolo(titolo);
	}
	
	@Override
	public List<Film> cercaFilmPerRegista(Regista regista)
	{
		return filmRepository.findByRegista(regista.getIdNome());
	}
	
	@Override
	public List<Film> cercaFilmPerAttore(Attore attore)
	{
		return filmRepository.findByAttore(attore.getIdNome());
	}
	
	@Override
	public List<Film> cercaFilmPerAnno(int anno)
	{
		return filmRepository.findByAnno(anno);
	}
	
	@Override
	public List<Film> cercaFilmPerGenere(String genere)
	{
		return filmRepository.findByGenere(genere);
	}
	
	@Override
	public List<Film> cercaTuttiFilm()
	{
		return filmRepository.findAll();
	}
}
