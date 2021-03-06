package it.cinema.videoteca.connector.regista;

import it.cinema.videoteca.om.Regista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistaJpaConnector implements RegistaConnector
{
	@Autowired
	private RegistaJpaRepository repository;
	
	@Override
	public Regista aggiungiRegista(Regista regista)
	{
		return repository.save(regista);
	}
	
	@Override
	public Regista rimuoviRegista(Regista regista)
	{
		Regista result = repository.findByIdNome(regista.getIdNome());
		return result != null ? result : null;
	}
	
	@Override
	public Regista rimuoviRegista(String idNome)
	{
		Regista result = repository.findByIdNome(idNome);
		return result != null ? result : null;
	}
	
	@Override
	public Regista aggiornaRegista(Regista regista)
	{
		return repository.save(regista);
	}
	
	@Override
	public Regista cercaRegistaPerIdNome(String idNome)
	{
		return repository.findByIdNome(idNome);
	}
	
	@Override
	public List<Regista> cercaRegistiPerNome(String nome)
	{
		return repository.findByNome(nome);
	}
	
	@Override
	public List<Regista> cercaRegistiPerCognome(String cognome)
	{
		return repository.findByCognome(cognome);
	}
}
