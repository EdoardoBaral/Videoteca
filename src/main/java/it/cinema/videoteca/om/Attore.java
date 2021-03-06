package it.cinema.videoteca.om;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "ATTORI")
public class Attore implements Comparable<Attore>
{
	@Id
	@Column(name = "ID_NOME")
	private String idNome;
	
	private String nome;
	private String cognome;
	
	@Column(name = "DATA_NASCITA")
	private LocalDate dataNascita;
	
	@Column(name = "DATA_MORTE")
	private LocalDate dataMorte;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "cast")
	private List<Film> filmografia;
	
	public Attore()
	{
		filmografia = new ArrayList<>();
	}
	
	public Attore(String nome, String cognome)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.idNome = cognome +", "+ nome;
		filmografia = new ArrayList<>();
	}
	
	public int compareTo(Attore attore)
	{
		if(this.idNome.compareToIgnoreCase(attore.getIdNome()) < 0)
			return -1;
		else if(this.idNome.compareToIgnoreCase(attore.getIdNome()) > 0)
			return 1;
		else
		{
			if(this.dataNascita == null && attore.getDataNascita() == null)
				return 0;
			else if(this.dataNascita == null && attore.getDataNascita() != null)
				return -1;
			else if(this.dataNascita != null && attore.getDataNascita() == null)
				return 1;
			
			if(this.dataNascita.isBefore(attore.getDataNascita()))
				return -1;
			else if(this.dataNascita.isAfter(attore.getDataNascita()))
				return 1;
			else
				return 0;
		}
	}
	
	public boolean equals(Attore attore)
	{
		if(attore == null)
			return false;
		else if(this == attore)
			return true;
		else
			return this.compareTo(attore) == 0;
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
