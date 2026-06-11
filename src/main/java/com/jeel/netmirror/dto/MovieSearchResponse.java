package com.jeel.netmirror.dto;
import java.util.List;
import com.jeel.netmirror.exception.OmdbMovieNotFoundException;

public class MovieSearchResponse {
    private List<MovieSearchItem> Search;
    private String Response;
    private String Error;

    public MovieSearchResponse() {
    }

    public List<MovieSearchItem> getSearch() {
        return Search;
    }

    public void setSearch(List<MovieSearchItem> search) {
        Search = search;
    }

    public void setResponse(String response) {
        Response = response;
    }

    public void setError(String error) {
        Error = error;
    }

    public String getResponse() {
        return Response;
    }

    public String getError() {
        return Error;
    }
}
