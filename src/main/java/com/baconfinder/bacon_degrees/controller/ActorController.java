package com.baconfinder.bacon_degrees.controller;

import com.baconfinder.bacon_degrees.model.NameBasics;
import com.baconfinder.bacon_degrees.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
@RequestMapping("/api/actors")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/search")
    public List<NameBasics> searchActors(@RequestParam String q) {
        return actorService.searchActorsByNamePrefix(q);
    }

    @GetMapping("/{id}")
    public NameBasics getActorById(@PathVariable String id) {
        return actorService.getActorById(id);
    }
}
