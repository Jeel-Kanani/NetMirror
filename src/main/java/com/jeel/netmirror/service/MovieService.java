package com.jeel.netmirror.service;

import com.jeel.netmirror.model.Movie;
import com.jeel.netmirror.exception.MovieNotFoundException;
import org.springframework.stereotype.Service;
import com.jeel.netmirror.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie getMovieById(String id){

        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    public boolean deleteMovieById(String id){

        Movie movie = getMovieById(id);

        movieRepository.delete(movie);

        return true;
    }

    public Movie updateMovie(String id, Movie updatedMovie){

        Movie movie = getMovieById(id);

        movie.setTitle(updatedMovie.getTitle());
        movie.setGenre(updatedMovie.getGenre());
        movie.setWatched(updatedMovie.isWatched());
        movie.setWatchLater(updatedMovie.isWatchLater());

        return movieRepository.save(movie);
    }

}
