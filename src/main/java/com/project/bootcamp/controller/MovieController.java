package com.project.bootcamp.controller;

import com.project.bootcamp.dto.MovieRequest;
import com.project.bootcamp.service.MovieService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping(value = "/addMovie")
    public String addMovie(@RequestBody MovieRequest request){
        String output = movieService.save(request);
        return output;
    }

    @GetMapping(value = "/getMovie/{id}")
    public String getDataMovieById(@PathVariable Long id){
        return movieService.get(id);
    }
}
