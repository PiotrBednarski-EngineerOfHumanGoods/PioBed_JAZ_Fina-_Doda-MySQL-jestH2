package pl.pjatk.piobed.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.piobed.homework.model.HomeworkResponse;

/**
 * Praca domowa ze zjazdu 3.
 *
 * Treść zadania:
 *   "Stwórz nowy RestController który przyjmie bazowy adres jako /homework.
 *    Zaimplementuj metodę GET która w jednym z przypadków przyjmie dowolny
 *    PathVariable, w innym RequestParam, i zwróci podane informacje jako obiekt.
 *    Stwórz dodatkowo logikę dla pozostałych metod PUT / POST / DELETE.
 *    Dla metody PUT skorzystaj z PathVariable oraz RequestBody.
 *    Dla metody POST skorzystaj z RequestBody.
 *    Dla metody DELETE skorzystaj z PathVariable.
 *    Niech metody PUT oraz POST zwrócą dostarczone dane, natomiast metoda DELETE
 *    niech zwraca jedynie HTTP status 200 bez żadnego body."
 */
@RestController
@RequestMapping("/homework")
public class HomeworkController {

    // GET z @PathVariable - wartość pobrana ze ścieżki, np. /homework/path/Ala -> value = "Ala".
    @GetMapping("/path/{value}")
    public ResponseEntity<HomeworkResponse> getByPathVariable(@PathVariable String value) {
        return ResponseEntity.ok(new HomeworkResponse(value, "PathVariable"));
    }

    // GET z @RequestParam - wartość pobrana z query stringa, np. /homework/param?value=Ala.
    @GetMapping("/param")
    public ResponseEntity<HomeworkResponse> getByRequestParam(@RequestParam String value) {
        return ResponseEntity.ok(new HomeworkResponse(value, "RequestParam"));
    }

    // POST z @RequestBody - dane przychodzą w ciele żądania jako JSON i są mapowane na obiekt.
    @PostMapping
    public ResponseEntity<HomeworkResponse> create(@RequestBody HomeworkResponse response) {
        return ResponseEntity.ok(response);
    }

    // PUT łączy oba mechanizmy: PathVariable z URL i RequestBody z ciała.
    @PutMapping("/{value}")
    public ResponseEntity<HomeworkResponse> update(@PathVariable String value,
                                                   @RequestBody HomeworkResponse response) {
        response.setValue(value);
        return ResponseEntity.ok(response);
    }

    // DELETE z PathVariable - zwraca tylko status 200 OK bez ciała odpowiedzi.
    @DeleteMapping("/{value}")
    public ResponseEntity<Void> delete(@PathVariable String value) {
        return ResponseEntity.ok().build();
    }
}
