package it.cinema.videoteca.om;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@Table(name = "REGISTI")
public class Regista implements Comparable<Regista>, Serializable
{
	private static final long serialVersionUID = -2599062502219349295L;
	
	@Id
	@Column(name = "ID_NOME")
	private String idNome;
	
	private String nome;
	private String cognome;
	
	@Column(name = "DATA_NASCITA")
	private LocalDate dataNascita;
	
	@Column(name = "DATA_MORTE")
	private LocalDate dataMorte;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "regia")
	private List<Film> filmografia;
	
	public Regista()
	{
		filmografia = new ArrayList<>();
	}
	
	public Regista(String nome, String cognome)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.idNome = cognome +", "+ nome;
		filmografia = new ArrayList<>();
	}
	
	public int compareTo(Regista regista)
	{
		if(this.idNome.compareToIgnoreCase(regista.getIdNome()) < 0)
			return -1;
		else if(this.idNome.compareToIgnoreCase(regista.getIdNome()) > 0)
			return 1;
		else
		{
			if(this.dataNascita == null && regista.getDataNascita() == null)
				return 0;
			else if(this.dataNascita == null && regista.getDataNascita() != null)
				return -1;
			else if(this.dataNascita != null && regista.getDataNascita() == null)
				return 1;
			
			if(this.dataNascita.isBefore(regista.getDataNascita()))
				return -1;
			else if(this.dataNascita.isAfter(regista.getDataNascita()))
				return 1;
			else
				return 0;
		}
	}
	
	public boolean equals(Regista regista)
	{
		if(regista == null)
			return false;
		else if(this == regista)
			return true;
		else
			return this.compareTo(regista) == 0;
	}
	
	public boolean esisteInFilmografia(Film film)
	{
		int indice = Collections.binarySearch(filmografia, film);
		return indice >= 0;
	}
	
	public boolean aggiungiFilm(Film film)
	{
		if(esisteInFilmografia(film))
			return false;
		else
		{
			filmografia.add(film);
			Collections.sort(filmografia);
			return true;
		}
	}
	
	public boolean rimuoviFilm(Film film)
	{
		int indice = Collections.binarySearch(filmografia, film);
		if(indice < 0)
			return false;
		else
		{
			filmografia.remove(film);
			return true;
		}
	}
	
	public boolean rimuoviFilm(String titolo)
	{
		Film film = new Film(titolo);
		int indice = Collections.binarySearch(filmografia, film);
		if(indice < 0)
			return false;
		else
		{
			filmografia.remove(film);
			return true;
		}
	}
	
	@Override
	public String toString()
	{
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			return mapper.writeValueAsString(this);
		}
		catch(JsonProcessingException e)
		{
			return null;
		}
	}
}
