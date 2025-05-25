package com.baconfinder.bacon_degrees.controller;


import com.baconfinder.bacon_degrees.model.TitleBasics;
import com.baconfinder.bacon_degrees.service.TitleBasicsService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")


@RestController
@RequestMapping("/api/movies")
public class TitleBasicsController {
    private final TitleBasicsService titleBasicsService;

    public TitleBasicsController(TitleBasicsService titleBasicsService) {
        this.titleBasicsService = titleBasicsService;
    }

    @GetMapping("/{tconst}")
    public TitleBasics getMovieById(@PathVariable String tconst) {
        return titleBasicsService.getMovieById(tconst).orElse(null);
    }
}
