package pl.pjatk.piobed.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pjatk.piobed.movie.model.Movie;

import java.util.List;
import java.util.Optional;

/**
 * Repository (warstwa dostępu do danych) dla encji Movie.
 *
 * Rozszerza JpaRepository<Movie, Long>, dzięki czemu od razu dostajemy gotowe metody:
 *   - findAll(), findById(id), save(entity), deleteById(id), existsById(id) ...
 *
 * Dodatkowo udostępnia własne metody korzystające z Named Queries z encji Movie -
 * to było zadanie z pracy domowej (zjazd 5): "przerób repository tak, aby korzystało
 * z Named Queries, ale nic nie zmieniło się po stronie serwisu".
 *
 * Adnotacja @Query(name = "...") wskazuje na nazwę @NamedQuery zdefiniowanego na encji.
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(name = "Movie.findAllNamed")
    List<Movie> findAllNamed();

    @Query(name = "Movie.findByIdNamed")
    Optional<Movie> findByIdNamed(Long id);

    @Query(name = "Movie.findAllAvailableNamed")
    List<Movie> findAllAvailableNamed();
}
