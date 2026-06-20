package pl.pjatk.piobed.movie.service;

import org.junit.jupiter.api.Test;
import pl.pjatk.piobed.movie.model.Movie;
import pl.pjatk.piobed.movie.repository.MovieRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class MovieServiceTest {

    @Test
    void shouldSetMovieAvailable() {
        MovieRepository movieRepository = mock(MovieRepository.class);
        Movie movie = new Movie("Matrix", "Sci-Fi", 1999, false);
        movie.setId(1L);

        when(movieRepository.findByIdNamed(1L)).thenReturn(Optional.of(movie));
        when(movieRepository.save(movie)).thenReturn(movie);

        MovieService movieService = new MovieService(movieRepository);

        Optional<Movie> result = movieService.setMovieAvailable(1L);

        assertTrue(result.isPresent());
        assertTrue(result.get().getIsAvailable());
        verify(movieRepository).save(movie);
    }
}
