package pl.pjatk.piobed.movie.model;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;

/**
 * Model filmu wypożyczalni.
 *
 * Klasa pełni dwie role:
 *   - encja JPA odwzorowana na tabelę "movie" w bazie danych (adnotacja @Entity),
 *   - model żądania/odpowiedzi REST - Jackson serializuje obiekt do JSON-a i z powrotem,
 *     dzięki czemu w kontrolerze działają @RequestBody Movie / ResponseEntity<Movie>.
 *
 * Adnotacje @Schema z pakietu io.swagger.v3 dodają opisy pól, które Swagger UI
 * pokazuje w sekcji "Schemas" pod listą endpointów.
 */
@Entity
@Schema(description = "Film dostępny w wypożyczalni")
@NamedQueries({
        // Named Query - zapytanie JPQL zarejestrowane pod nazwą.
        // Wywoływane z repository przez @Query(name = "Movie.findAllNamed").
        @NamedQuery(
                name = "Movie.findAllNamed",
                query = "SELECT movie FROM Movie movie"
        ),
        @NamedQuery(
                name = "Movie.findByIdNamed",
                query = "SELECT movie FROM Movie movie WHERE movie.id = :id"
        ),
        @NamedQuery(
                name = "Movie.findAllAvailableNamed",
                query = "SELECT movie FROM Movie movie WHERE movie.isAvailable = true"
        )
})
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unikalny identyfikator filmu, generowany automatycznie przez bazę", example = "1")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Tytuł filmu", example = "Incepcja", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Column(nullable = false)
    @Schema(description = "Kategoria / gatunek filmu", example = "Sci-Fi", requiredMode = Schema.RequiredMode.REQUIRED)
    private String category;

    @Schema(description = "Rok produkcji filmu", example = "2010")
    private Integer productionYear;

    @Column(nullable = false)
    @Schema(description = "Czy film jest dostępny do wypożyczenia (true = dostępny, false = wypożyczony)", example = "false")
    private Boolean isAvailable = false;

    public Movie() {
    }

    public Movie(String name, String category, Integer productionYear, Boolean isAvailable) {
        this.name = name;
        this.category = category;
        this.productionYear = productionYear;
        this.isAvailable = isAvailable == null ? false : isAvailable;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public void setIsAvailable(Boolean available) {
        isAvailable = available;
    }
}
