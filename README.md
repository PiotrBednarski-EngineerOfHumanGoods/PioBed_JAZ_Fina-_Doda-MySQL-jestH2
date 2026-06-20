# MovieService (PioBed)

Projekt z przedmiotu Java Zaawansowana — PJATK, zjazdy 1–7.

## Uruchomienie

1. Utwórz bazę danych MySQL:

```sql
CREATE DATABASE piobed;
```

2. W pliku `src/main/resources/application.yml` ustaw hasło do MySQL (pole `password`).

3. Uruchom aplikację:

```bash
mvn clean spring-boot:run
```

Aplikacja nasłuchuje na **porcie 8081** (potrzebne, bo RentalService woła do `localhost:8081`).

## Swagger / OpenAPI

- Swagger UI: <http://localhost:8081/swagger-ui.html>
- Specyfikacja JSON: <http://localhost:8081/v3/api-docs>

## Endpointy

### Filmy (grupa „Filmy" w Swagger UI)
```
GET     /movies
GET     /movies/available
GET     /movies/{id}
POST    /movies
PUT     /movies/{id}
PATCH   /movies/{id}/available
PATCH   /movies/{id}/rent
DELETE  /movies/{id}
```

### Ćwiczenia ze zjazdu 3 (TestController)
```
GET     /test/hello
GET     /test/model
GET     /test/hello/{someValue}
GET     /test/hello-param?reqParam=value
POST    /test/model
```

### Praca domowa zjazd 3 (HomeworkController)
```
GET     /homework/path/{value}
GET     /homework/param?value=...
POST    /homework
PUT     /homework/{value}
DELETE  /homework/{value}
```

### Ćwiczenie zjazd 4 (Exception)
```
GET     /excpetion        # uwaga: literówka jest celowa (taką ścieżkę podał prowadzący)
```

## Ściągawka — gdzie szukać czego w kodzie

| Temat | Plik |
|---|---|
| **REST controller** (GET/POST/PUT/DELETE) | `movie/controller/MovieController.java`, `test/controller/TestController.java`, `homework/controller/HomeworkController.java` |
| **@PathVariable** | `MovieController.getMovieById`, `HomeworkController.getByPathVariable` |
| **@RequestParam** | `HomeworkController.getByRequestParam`, `TestController.getRequestParam` |
| **@RequestBody** | `MovieController.addMovie`, `TestController.postModel` |
| **ResponseEntity** | wszędzie w kontrolerach |
| **Model generowany z JSON-a (POJO)** | `test/model/Car.java`, `homework/model/HomeworkResponse.java`, `movie/model/Movie.java` |
| **Jackson serializacja** | komentarze w `Car.java` i `HomeworkResponse.java` |
| **JPA Entity** | `movie/model/Movie.java` |
| **Named Query** | `movie/model/Movie.java` (`@NamedQueries`) + `movie/repository/MovieRepository.java` (`@Query(name=...)`) |
| **JpaRepository** | `movie/repository/MovieRepository.java` |
| **@Service + DI przez konstruktor** | `movie/service/MovieService.java`, `sandbox/service/SandboxService.java` |
| **@Component** | `component/MyFirstComponent.java`, `component/MySecondComponent.java`, `executor/RequestExecutor.java` |
| **Bean XML** | `resources/beans.xml` + `component/XmlFirstComponent.java`, `XmlSecondComponent.java` |
| **@Bean (w @Configuration)** | `configuration/BeanConfiguration.java` |
| **@ConfigurationProperties** | `configuration/AppProperties.java` (prefix `app.`) |
| **@Value("${...}")** | `configuration/BeanConfiguration.simplePojo` |
| **Profile / application-*.yml** | `resources/application-dev.yml`, `application-qa.yml`, `application-prod.yml` |
| **@ConditionalOnProperty** | `profile/ProfileBeanConfiguration.java` |
| **CommandLineRunner** | `executor/RequestExecutor.java`, `component/ApplicationContextRunner.java` |
| **Wzorzec Facade + List<Interface>** | `handler/FacadeService.java` + Dev/Qa/Prod/Staging Service |
| **@RestControllerAdvice + @ExceptionHandler** | `advice/GlobalExceptionHandler.java` |
| **Endpoint który rzuca exception** | `sandbox/controller/ExceptionController.java` + `SandboxService.java` |
| **Swagger @Tag + @Operation** | `MovieController.java` |
| **Swagger @Schema** | `Movie.java` |
| **Testy z Mockito** | `src/test/java/.../MovieServiceTest.java`, `FacadeServiceTest.java` |

## Mapa zjazdów

- **Zjazd 3** — `test/`, `homework/` (REST, PathVariable, RequestParam, RequestBody)
- **Zjazd 4** — `sandbox/` (exception), `advice/` (RestControllerAdvice), `movie/` (CRUD Movie)
- **Zjazd 5** — JPA, NamedQuery, isAvailable, PATCH `/movies/{id}/available`
- **Zjazd 6** — RentalService (osobny projekt) + PATCH `/movies/{id}/rent` (po stronie MovieService)
- **Zjazd 7** — Swagger (Tag + Operation + Schema) + projekt NbpService (osobny folder)
