package it.cinema.videoteca.connector.attore;

import it.cinema.videoteca.om.Attore;

import java.util.List;

public interface AttoreConnector
{
	Attore aggiungiAttore(Attore attore);
	Attore rimuoviAttore(Attore attore);
	Attore rimuoviAttore(String idNome);
	Attore aggiornaAttore(Attore attore);
	Attore cercaAttorePerIdNome(String idNome);
	List<Attore> cercaAttoriPerNome(String nome);
	List<Attore> cercaAttoriPerCognome(String cognome);
}
