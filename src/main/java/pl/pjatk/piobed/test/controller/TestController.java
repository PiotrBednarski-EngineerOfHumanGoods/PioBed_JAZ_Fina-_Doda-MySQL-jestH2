package pl.pjatk.piobed.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.piobed.test.model.Car;

/**
 * Ćwiczenia 1-5 ze zjazdu 3.
 *
 * Treści zadań:
 *   Ćw.1: "Stwórz RestController, który po wykonaniu zapytania GET na adres
 *          localhost:8080/test/hello zwróci ResponseEntity z Stringiem 'Hello world'."
 *   Ćw.2: "Stwórz nową klasę reprezentującą dowolny model (np. Car). Stwórz nowy
 *          endpoint, który po wykonaniu zapytania GET na localhost:8080/test/model
 *          zwróci nowy obiekt klasy którą utworzyłeś."
 *   Ćw.3: "Endpoint GET na adres localhost:8080/test/hello/{someValue} zwraca
 *          ResponseEntity z Stringiem {someValue}." (przykład @PathVariable)
 *   Ćw.4: "Endpoint GET na adres localhost:8080/test/hello-param?reqParam={someValue}
 *          zwraca ResponseEntity z Stringiem {someValue}." (przykład @RequestParam)
 *   Ćw.5: "Endpoint POST na localhost:8080/test/model skorzysta z danych dostarczonych
 *          w body i zwróci nowy obiekt korzystający z tych danych." (@RequestBody)
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("Hello world");
    }

    @GetMapping("/model")
    public ResponseEntity<Car> getModel() {
        // Zwracany obiekt Car -> Jackson serializuje go do JSON-a.
        return ResponseEntity.ok(new Car("Volkswagen", "Golf Plus", 2008));
    }

    @GetMapping("/hello/{someValue}")
    public ResponseEntity<String> getPathVariable(@PathVariable String someValue) {
        return ResponseEntity.ok(someValue);
    }

    @GetMapping("/hello-param")
    public ResponseEntity<String> getRequestParam(@RequestParam String reqParam) {
        return ResponseEntity.ok(reqParam);
    }

    @PostMapping("/model")
    public ResponseEntity<Car> postModel(@RequestBody Car car) {
        return ResponseEntity.ok(car);
    }
}
