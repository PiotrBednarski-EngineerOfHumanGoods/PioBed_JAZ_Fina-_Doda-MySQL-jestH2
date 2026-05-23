package pl.pjatk.piobed.movie.model;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Movie.findAllNamed",
                query = "SELECT movie FROM Movie movie"
        ),
        @NamedQuery(
                name = "Movie.findByIdNamed",
                query = "SELECT movie FROM Movie movie WHERE movie.id = :id"
        ),
        @NamedQuery(
                name = "Movie.findAvailableNamed",
                query = "SELECT movie FROM Movie movie WHERE movie.isAvailable = true"
        )
})
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    private Integer productionYear;

    @Column(nullable = false)
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
