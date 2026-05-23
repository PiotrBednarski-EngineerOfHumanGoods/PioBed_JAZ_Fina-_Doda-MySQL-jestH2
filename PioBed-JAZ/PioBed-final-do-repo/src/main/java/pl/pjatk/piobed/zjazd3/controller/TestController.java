package pl.pjatk.piobed.zjazd3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.piobed.zjazd3.model.Car;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public ResponseEntity<String> getHelloWorld() {
        return ResponseEntity.ok("Hello world");
    }

    @GetMapping("/model")
    public ResponseEntity<Car> getModel() {
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
