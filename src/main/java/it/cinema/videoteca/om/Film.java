package it.cinema.videoteca.om;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@Table(name= "FILM")
public class Film implements Comparable<Film>
{
	@Id
	private String titolo;
	
	@ManyToMany
	@JoinTable(name = "REGIA", joinColumns = @JoinColumn(name = "TITOLO"), inverseJoinColumns = @JoinColumn(name = "ID_NOME"))
	private List<Regista> regia;
	
	@ManyToMany
	@JoinTable(name = "CAST", joinColumns = @JoinColumn(name = "TITOLO"), inverseJoinColumns = @JoinColumn(name = "ID_NOME"))
	private List<Attore> cast;
	
	private String genere;
	private int anno;
	
	public Film()
	{
		regia = new ArrayList<>();
		cast = new ArrayList<>();
	}
	
	public Film(String titolo)
	{
		this.titolo = titolo;
		regia = new ArrayList<>();
		cast = new ArrayList<>();
	}
	
	public boolean esisteInRegia(Regista regista)
	{
		int indice = Collections.binarySearch(this.regia, regista);
		return indice >= 0 ? true : false;
	}
	
	public boolean esisteInCast(Attore attore)
	{
		int indice = Collections.binarySearch(this.cast, attore);
		return indice >= 0 ? true : false;
	}
	
	public boolean aggiungiRegista(Regista regista)
	{
		if(esisteInRegia(regista))
			return false;
		else
		{
			this.regia.add(regista);
			Collections.sort(regia);
			return true;
		}
	}
	
	public boolean aggiungiAttore(Attore attore)
	{
		if(esisteInCast(attore))
			return false;
		else
		{
			this.cast.add(attore);
			Collections.sort(cast);
			return true;
		}
	}
	
	public boolean rimuoviRegista(Regista regista)
	{
		int indice = Collections.binarySearch(this.regia, regista);
		if(indice < 0)
			return false;
		else
		{
			this.regia.remove(indice);
			return true;
		}
	}
	
	public boolean rimuoviAttore(Attore attore)
	{
		int indice = Collections.binarySearch(this.cast, attore);
		if(indice < 0)
			return false;
		else
		{
			this.cast.remove(indice);
			return true;
		}
	}
	
	@Override
	public int compareTo(Film film)
	{
		if(this.titolo.compareToIgnoreCase(film.getTitolo()) < 0)
			return -1;
		else if(this.titolo.compareToIgnoreCase(film.getTitolo()) > 0)
			return 1;
		else
		{
			if(this.anno < film.getAnno())
				return -1;
			else if(this.anno > film.getAnno())
				return 1;
			else
				return 0;
		}
	}
	
	public boolean equals(Film film)
	{
		return this.compareTo(film) == 0 ? true : false;
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