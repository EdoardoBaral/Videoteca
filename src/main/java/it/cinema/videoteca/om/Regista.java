package it.cinema.videoteca.om;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "REGISTI")
public class Regista implements Comparable<Regista>
{
	@Id
	@Column(name = "ID_NOME")
	private String idNome;
	
	private String nome;
	private String cognome;
	
	@Column(name = "DATA_NASCITA")
	private DateTime dataNascita;
	
	@Column(name = "DATA_MORTE")
	private DateTime dataMorte;
	
	@ManyToMany(mappedBy = "regia")
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
			else
				return Long.compare(this.dataNascita.getMillis(), regista.getDataNascita().getMillis());
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
