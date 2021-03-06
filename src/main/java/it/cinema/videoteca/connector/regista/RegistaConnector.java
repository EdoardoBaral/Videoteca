package it.cinema.videoteca.connector.regista;

import it.cinema.videoteca.om.Regista;

import java.util.List;

public interface RegistaConnector
{
	Regista aggiungiRegista(Regista regista);
	Regista rimuoviRegista(Regista regista);
	Regista rimuoviRegista(String idNome);
	Regista aggiornaRegista(Regista regista);
	Regista cercaRegistaPerIdNome(String idNome);
	List<Regista> cercaRegistiPerNome(String nome);
	List<Regista> cercaRegistiPerCognome(String cognome);
}
