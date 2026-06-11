package com.jeel.netmirror.dto;

public class MovieSearchItem {
    private String Title;
    private String Year;
    private String imdbID;
    private String Poster;

    public MovieSearchItem() {
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setYear(String year) {
        Year = year;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getTitle() {
        return Title;
    }

    public String getYear() {
        return Year;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getPoster() {
        return Poster;
    }
}
