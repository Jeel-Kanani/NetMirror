package com.jeel.netmirror.service;

import com.jeel.netmirror.model.Movie;
import com.jeel.netmirror.exception.MovieNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    private final List<Movie> movies = new ArrayList<>();
    private Long nextId = 1L;

    public List<Movie> getAllMovies() {
        return movies;
    }

    public Movie addMovie(Movie movie) {
        movie.setId(nextId);
        nextId++;
        movies.add(movie);
        return movie;
    }

    public Movie getMovieById(Long id){

        for(Movie movie:movies) {
            if (movie.getId().equals(id)) {
                return movie;
            }
        }
        throw new MovieNotFoundException(id);
    }

    public boolean deleteMovieById(Long id){
        for (int i = 0; i < movies.size(); i++) {

            if (movies.get(i).getId().equals(id)) {
                movies.remove(i);
                return true;
            }
        }
        return false;
    }

    public Movie updateMovie(Long id,Movie updatedMovie){
        for(Movie movie:movies){
            if(movie.getId().equals(id)){
                movie.setTitle(updatedMovie.getTitle());
                movie.setGenre(updatedMovie.getGenre());
                movie.setWatched(updatedMovie.isWatched());
                movie.setWatchLater(updatedMovie.isWatchLater());
                return movie;
            }
        }
        return null;
    }
}
