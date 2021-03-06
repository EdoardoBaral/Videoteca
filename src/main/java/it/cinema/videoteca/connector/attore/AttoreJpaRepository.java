package it.cinema.videoteca.connector.attore;

import it.cinema.videoteca.om.Attore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AttoreJpaRepository extends JpaRepository<Attore, String>
{
	Attore findByIdNome(String idNome);
	List<Attore> findByNome(String nome);
	List<Attore> findByCognome(String cognome);
}
