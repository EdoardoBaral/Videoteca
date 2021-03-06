package it.cinema.videoteca.connector.regista;

import it.cinema.videoteca.om.Regista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RegistaJpaRepository extends JpaRepository<Regista, String>
{
	Regista findByIdNome(String idNome);
	List<Regista> findByNome(String nome);
	List<Regista> findByCognome(String cognome);
}
