package com.jeel.netmirror.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.jeel.netmirror.dto.OmdbMovieResponse;
import com.jeel.netmirror.exception.OmdbMovieNotFoundException;
import com.jeel.netmirror.dto.MovieSearchResponse;

@Service
public class OmdbService {

    @Value("${omdb.api.key}")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }

    public OmdbMovieResponse searchMovie(String title) {

        String url =
                "https://www.omdbapi.com/?apikey="
                        + apiKey
                        + "&t="
                        + title;

        RestClient restClient = RestClient.create();

        OmdbMovieResponse response =
                restClient.get()
                        .uri(url)
                        .retrieve()
                        .body(OmdbMovieResponse.class);

        if ("False".equals(response.getResponse())) {
            throw new OmdbMovieNotFoundException(response.getError());
        }

        return response;
    }

    public MovieSearchResponse searchMovies(String query){
        String url =
                "https://www.omdbapi.com/?apikey="
                        + apiKey
                        + "&s="
                        + query;
        RestClient restClient=RestClient.create();
        MovieSearchResponse response =
                restClient.get()
                        .uri(url)
                        .retrieve()
                        .body(MovieSearchResponse.class);

        if ("False".equals(response.getResponse())) {
            throw new OmdbMovieNotFoundException(response.getError());
        }

        return response;
    }

    public OmdbMovieResponse getMovieByImdbId(String imdbId) {

        String url =
                "https://www.omdbapi.com/?apikey="
                        + apiKey
                        + "&i="
                        + imdbId;

        RestClient restClient = RestClient.create();

        OmdbMovieResponse response =
                restClient.get()
                        .uri(url)
                        .retrieve()
                        .body(OmdbMovieResponse.class);

        if ("False".equals(response.getResponse())) {
            throw new OmdbMovieNotFoundException(response.getError());
        }

        return response;
    }
}
