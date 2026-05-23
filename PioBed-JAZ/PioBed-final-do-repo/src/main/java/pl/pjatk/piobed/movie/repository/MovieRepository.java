package pl.pjatk.piobed.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.pjatk.piobed.movie.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(name = "Movie.findAllNamed")
    List<Movie> findAllNamed();

    @Query(name = "Movie.findByIdNamed")
    Optional<Movie> findByIdNamed(Long id);

    @Query(name = "Movie.findAvailableNamed")
    List<Movie> findAvailableNamed();
}
