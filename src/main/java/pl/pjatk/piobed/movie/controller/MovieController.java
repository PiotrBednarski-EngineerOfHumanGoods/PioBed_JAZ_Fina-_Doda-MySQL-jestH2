package pl.pjatk.piobed.movie.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.piobed.movie.model.Movie;
import pl.pjatk.piobed.movie.service.MovieService;

import java.util.List;

/**
 * Kontroler REST dla zasobu Movie.
 *
 * Adnotacja @RestController łączy w sobie @Controller + @ResponseBody - każda metoda
 * zwraca obiekt, który Jackson automatycznie zamienia na JSON (lub na ciało odpowiedzi
 * opakowane w ResponseEntity).
 *
 * @RequestMapping("/movies") ustawia wspólny prefix ścieżki dla wszystkich endpointów
 * w tej klasie.
 *
 * Adnotacja @Tag z OpenAPI grupuje endpointy w Swagger UI pod wspólną nazwą "Filmy".
 */
@RestController
@RequestMapping("/movies")
@Tag(name = "Filmy", description = "Endpointy do zarządzania filmami w wypożyczalni")
public class MovieController {

    private final MovieService movieService;

    // Wstrzykiwanie zależności (Dependency Injection) przez konstruktor.
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @Operation(summary = "Pobierz wszystkie filmy")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/available")
    @Operation(summary = "Pobierz dostępne filmy")
    public ResponseEntity<List<Movie>> getAvailableMovies() {
        return ResponseEntity.ok(movieService.getAvailableMovies());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Pobierz film po ID")
    public ResponseEntity<Movie> getMovieById(
            @Parameter(description = "ID filmu", example = "1") @PathVariable Long id
    ) {
        // Optional.map - jeżeli film istnieje zwracamy 200 OK z ciałem, w przeciwnym razie 404.
        return movieService.getMovieById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Dodaj nowy film")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        // Walidacja minimalnych danych - bez nazwy i kategorii zwracamy 400 BAD REQUEST.
        if (movie.getName() == null || movie.getCategory() == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Zaktualizuj film")
    public ResponseEntity<Movie> updateMovie(
            @Parameter(description = "ID filmu do aktualizacji") @PathVariable Long id,
            @RequestBody Movie movie
    ) {
        if (movie.getName() == null || movie.getCategory() == null) {
            return ResponseEntity.badRequest().build();
        }

        return movieService.updateMovie(id, movie)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/available")
    @Operation(summary = "Oznacz film jako dostępny")
    public ResponseEntity<Movie> setMovieAvailable(@PathVariable Long id) {
        return movieService.setMovieAvailable(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/rent")
    @Operation(summary = "Wypożycz film")
    public ResponseEntity<Movie> rentMovie(@PathVariable Long id) {
        return movieService.setMovieRented(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Usuń film")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        boolean deleted = movieService.deleteMovie(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        // 204 No Content - poprawne usunięcie bez ciała odpowiedzi.
        return ResponseEntity.noContent().build();
    }
}
