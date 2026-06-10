package com.jeel.netmirror.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jeel.netmirror.service.MovieService;   //For connecting controller and service
import com.jeel.netmirror.model.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import java.util.List;


@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/api/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping("/api/movies")
    public ResponseEntity<Movie> addMovie(@Valid @RequestBody Movie movie) {   //Request body for Postman request's JSON data spring automatically convert into Movie movie object
        Movie savedMovie=movieService.addMovie(movie);
        return ResponseEntity.status(201).body(savedMovie);
    }

    @GetMapping("/api/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie=movieService.getMovieById(id);
        if(movie==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("/api/movies/{id}")
    public boolean deleteMovieById(@PathVariable Long id) {
        return movieService.deleteMovieById(id);
    }

    @PutMapping("/api/movies/{id}")
    public Movie updateMovie(@PathVariable Long id,
                             @RequestBody Movie updatedMovie) {
        return movieService.updateMovie(id, updatedMovie);
    }
}
