package pl.pjatk.piobed.zjazd3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.piobed.zjazd3.model.HomeworkResponse;

@RestController
@RequestMapping("/homework")
public class HomeworkController {

    @GetMapping("/path/{value}")
    public ResponseEntity<HomeworkResponse> getByPathVariable(@PathVariable String value) {
        return ResponseEntity.ok(new HomeworkResponse(value, "PathVariable"));
    }

    @GetMapping("/param")
    public ResponseEntity<HomeworkResponse> getByRequestParam(@RequestParam String value) {
        return ResponseEntity.ok(new HomeworkResponse(value, "RequestParam"));
    }

    @PostMapping
    public ResponseEntity<HomeworkResponse> create(@RequestBody HomeworkResponse response) {
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{value}")
    public ResponseEntity<HomeworkResponse> update(@PathVariable String value,
                                                   @RequestBody HomeworkResponse response) {
        response.setValue(value);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{value}")
    public ResponseEntity<Void> delete(@PathVariable String value) {
        return ResponseEntity.ok().build();
    }
}
