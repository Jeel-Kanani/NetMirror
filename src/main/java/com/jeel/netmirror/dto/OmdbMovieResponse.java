package com.jeel.netmirror.dto;

public class OmdbMovieResponse {

    private String Title;
    private String Year;
    private String Genre;
    private String imdbRating;
    private String Poster;
    private String Response;
    private String Error;
    private String Plot;
    private String Director;

    public void setPlot(String plot) {
        Plot = plot;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public void setReleased(String released) {
        Released = released;
    }

    private String Actors;
    private String Runtime;
    private String Released;

    public String getPlot() {
        return Plot;
    }

    public String getDirector() {
        return Director;
    }

    public String getActors() {
        return Actors;
    }

    public String getRuntime() {
        return Runtime;
    }

    public String getReleased() {
        return Released;
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

    public OmdbMovieResponse() {
    }

    public String getTitle() {
        return Title;
    }

    public String getYear() {
        return Year;
    }



    public void setTitle(String title) {
        Title = title;
    }

    public void setYear(String year) {
        Year = year;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getGenre() {
        return Genre;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getPoster() {
        return Poster;
    }
}
