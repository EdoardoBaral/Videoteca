package it.cinema.videoteca.connector.film;

import it.cinema.videoteca.om.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FilmJpaRepository extends JpaRepository<Film, String>
{
	Film findByTitolo(String titolo);
	
	@Query(value = "select * from FILM f join REGIA r on (f.TITOLO = r.TITOLO) where r.ID_NOME = :nome order by f.TITOLO asc", nativeQuery = true)
	List<Film> findByRegista(@Param("nome") String regista);
	
	@Query(value = "select * from FILM f join CAST c on (f.TITOLO = c.TITOLO) where c.ID_NOME = :nome order by f.TITOLO asc", nativeQuery = true)
	List<Film> findByAttore(@Param("nome") String attore);
	
	@Query(value = "select * from FILM where ANNO = :anno order by TITOLO asc", nativeQuery = true)
	List<Film> findByAnno(@Param("anno") int anno);
	
	@Query(value = "select * from FILM where GENERE = :genere order by TITOLO asc", nativeQuery = true)
	List<Film> findByGenere(@Param("genere") String genere);
}
