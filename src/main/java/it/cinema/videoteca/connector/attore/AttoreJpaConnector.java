package it.cinema.videoteca.connector.attore;

import it.cinema.videoteca.om.Attore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttoreJpaConnector implements AttoreConnector
{
	@Autowired
	private AttoreJpaRepository repository;
	
	@Override
	public Attore aggiungiAttore(Attore attore)
	{
		return repository.save(attore);
	}
	
	@Override
	public Attore rimuoviAttore(Attore attore)
	{
		Attore result = repository.findByIdNome(attore.getIdNome());
		return result != null ? result : null;
	}
	
	@Override
	public Attore rimuoviAttore(String idNome)
	{
		Attore result = repository.findByIdNome(idNome);
		return result != null ? result : null;
	}
	
	@Override
	public Attore aggiornaAttore(Attore attore)
	{
		return repository.save(attore);
	}
	
	@Override
	public Attore cercaAttorePerIdNome(String idNome)
	{
		return repository.findByIdNome(idNome);
	}
	
	@Override
	public List<Attore> cercaAttoriPerNome(String nome)
	{
		return repository.findByNome(nome);
	}
	
	@Override
	public List<Attore> cercaAttoriPerCognome(String cognome)
	{
		return repository.findByCognome(cognome);
	}
}
