package pl.pjatk.piobed.zjazd4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.piobed.zjazd4.service.SandboxService;

@RestController
public class ExceptionController {

    private final SandboxService sandboxService;

    public ExceptionController(SandboxService sandboxService) {
        this.sandboxService = sandboxService;
    }

    @GetMapping("/exception")
    public String exception() {
        return sandboxService.throwException();
    }

    @GetMapping("/excpetion")
    public String exceptionWithTypoFromExercise() {
        return sandboxService.throwException();
    }
}
