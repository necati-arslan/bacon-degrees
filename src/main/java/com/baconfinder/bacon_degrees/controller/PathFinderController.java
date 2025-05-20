package com.baconfinder.bacon_degrees.controller;

import com.baconfinder.bacon_degrees.dto.PathResponse;
import com.baconfinder.bacon_degrees.service.PathFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/path")
public class PathFinderController {

    private final PathFinderService pathFinderService;

    @Autowired
    public PathFinderController(PathFinderService pathFinderService) {
        this.pathFinderService = pathFinderService;
    }

    @GetMapping
    public PathResponse getShortestPath(@RequestParam String from, @RequestParam String to) {

        return pathFinderService.findShortestPath(from, to);
    }
}
