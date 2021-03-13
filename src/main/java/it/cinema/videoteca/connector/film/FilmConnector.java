package it.cinema.videoteca.connector.film;

import it.cinema.videoteca.om.Attore;
import it.cinema.videoteca.om.Film;
import it.cinema.videoteca.om.Regista;

import java.util.List;

public interface FilmConnector
{
	Film aggiungiFilm(Film film);
	Film rimuoviFilm(Film film);
	Film rimuoviFilm(String titolo);
	Film aggiornaFilm(Film film);
	Film cercaFilmPerTitolo(String titolo);
	List<Film> cercaFilmPerRegista(Regista regista);
	List<Film> cercaFilmPerAttore(Attore attore);
	List<Film> cercaFilmPerAnno(int anno);
	List<Film> cercaFilmPerGenere(String genere);
	List<Film> cercaTuttiFilm();
}
