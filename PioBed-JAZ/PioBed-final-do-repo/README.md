# PioBed

Projekt z przedmiotu Java zaawansowana.

Aplikacja Spring Boot zawiera przykłady:

- komponentów Springa i wstrzykiwania zależności,
- konfiguracji przez `application.yml`,
- profili aplikacji,
- prostych endpointów REST,
- globalnej obsługi wyjątków,
- podziału na controller, service, repository i model,
- encji `Movie`,
- repozytorium Spring Data JPA,
- operacji CRUD,
- prostych Named Queries,
- pola `isAvailable`.

## Uruchomienie

```bash
mvn clean spring-boot:run
```

Domyślnie aplikacja używa bazy H2.

## Uruchomienie z profilem dev

```bash
mvn clean spring-boot:run -Dspring-boot.run.profiles=dev
```

## Uruchomienie z MySQL

Najpierw należy utworzyć bazę danych:

```sql
CREATE DATABASE piobed;
```

Następnie w pliku `src/main/resources/application-mysql.yml` należy ustawić hasło do bazy.

```bash
mvn clean spring-boot:run -Dspring-boot.run.profiles=mysql
```

## Główne endpointy

```text
GET     /movies
GET     /movies/{id}
GET     /movies/available
POST    /movies
PUT     /movies/{id}
PATCH   /movies/{id}/available
DELETE  /movies/{id}
```
