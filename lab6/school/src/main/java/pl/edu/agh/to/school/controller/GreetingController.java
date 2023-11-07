package pl.edu.agh.to.school.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class GreetingController {
    @GetMapping
    public String greeting() {
        return "Technologie obiektowe";
    }
}
