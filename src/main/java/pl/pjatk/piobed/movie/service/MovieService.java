package pl.pjatk.piobed.movie.service;

import org.springframework.stereotype.Service;
import pl.pjatk.piobed.movie.model.Movie;
import pl.pjatk.piobed.movie.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

/**
 * Warstwa logiki biznesowej dla filmów.
 *
 * Adnotacja @Service rejestruje klasę jako Spring Bean - dzięki temu
 * MovieController może otrzymać tę zależność wstrzykniętą przez konstruktor.
 *
 * Wstrzykiwanie zależności (DI) idzie przez konstruktor, nie przez @Autowired na polu -
 * to preferowany sposób, bo pole final wymusza inicjalizację i ułatwia testy.
 */
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAllNamed();
    }

    public List<Movie> getAvailableMovies() {
        return movieRepository.findAllAvailableNamed();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findByIdNamed(id);
    }

    public Movie addMovie(Movie movie) {
        // Wymuszamy null na ID - klient nie może narzucić własnego identyfikatora
        // (baza generuje go sama przez GenerationType.IDENTITY).
        movie.setId(null);

        if (movie.getIsAvailable() == null) {
            movie.setIsAvailable(false);
        }

        return movieRepository.save(movie);
    }

    public Optional<Movie> updateMovie(Long id, Movie movieFromRequest) {
        Optional<Movie> movieOptional = movieRepository.findByIdNamed(id);

        if (movieOptional.isEmpty()) {
            return Optional.empty();
        }

        Movie movieFromDatabase = movieOptional.get();
        movieFromDatabase.setName(movieFromRequest.getName());
        movieFromDatabase.setCategory(movieFromRequest.getCategory());
        movieFromDatabase.setProductionYear(movieFromRequest.getProductionYear());

        if (movieFromRequest.getIsAvailable() != null) {
            movieFromDatabase.setIsAvailable(movieFromRequest.getIsAvailable());
        }

        return Optional.of(movieRepository.save(movieFromDatabase));
    }

    public boolean deleteMovie(Long id) {
        if (!movieRepository.existsById(id)) {
            return false;
        }

        movieRepository.deleteById(id);
        return true;
    }

    /**
     * Oznaczenie filmu jako dostępnego (zwrócony do wypożyczalni).
     * Wywoływane przez RentalService.returnMovie() przez REST.
     */
    public Optional<Movie> setMovieAvailable(Long id) {
        Optional<Movie> movieOptional = movieRepository.findByIdNamed(id);

        if (movieOptional.isEmpty()) {
            return Optional.empty();
        }

        Movie movie = movieOptional.get();
        movie.setIsAvailable(true);

        return Optional.of(movieRepository.save(movie));
    }

    /**
     * Oznaczenie filmu jako wypożyczonego (isAvailable = false).
     * Wywoływane przez RentalService.rentMovie() przez REST.
     */
    public Optional<Movie> setMovieRented(Long id) {
        Optional<Movie> movieOptional = movieRepository.findByIdNamed(id);

        if (movieOptional.isEmpty()) {
            return Optional.empty();
        }

        Movie movie = movieOptional.get();
        movie.setIsAvailable(false);

        return Optional.of(movieRepository.save(movie));
    }
}
