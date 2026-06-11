package com.jeel.netmirror.controller;

import com.jeel.netmirror.service.OmdbService;
import org.springframework.web.bind.annotation.*;

import com.jeel.netmirror.service.MovieService;   //For connecting controller and service
import com.jeel.netmirror.model.Movie;

import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import com.jeel.netmirror.dto.OmdbMovieResponse;
import com.jeel.netmirror.dto.MovieSearchResponse;


@RestController
public class MovieController {

    private final MovieService movieService;
    private final OmdbService omdbService;

    public MovieController(MovieService movieService,
                           OmdbService omdbService) {
        this.movieService = movieService;
        this.omdbService = omdbService;
    }

    @GetMapping("/api/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @PostMapping("/api/movies")
    public ResponseEntity<Movie> addMovie(@Valid @RequestBody Movie movie) {   //Request body for Postman request's JSON data spring automatically convert into Movie movie object
        Movie savedMovie = movieService.addMovie(movie);
        return ResponseEntity.status(201).body(savedMovie);
    }

    @GetMapping("/api/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);
        if (movie == null) {
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
    @GetMapping("/api/search")
    public OmdbMovieResponse searchMovie(@RequestParam String title){
        return omdbService.searchMovie(title);
    }

    @GetMapping("/api/search/movies")
    public MovieSearchResponse searchMovies(
            @RequestParam String query) {

        return omdbService.searchMovies(query);
    }

    @GetMapping("/api/movie/{imdbId}")
    public OmdbMovieResponse getMovieByImdbId(
            @PathVariable String imdbId) {

        return omdbService.getMovieByImdbId(imdbId);
    }
}
