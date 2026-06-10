package com.jeel.netmirror.model;

import jakarta.validation.constraints.NotBlank;

public class Movie {
    private Long id;
    @NotBlank(message = "Title cannot be empty")
    private String title;
    @NotBlank(message = "Genre cannot be empty")
    private String genre;
    private boolean watched;
    private boolean watchLater;

    public Movie(Long id, String title, String genre, boolean watched, boolean watchLater) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.watched = watched;
        this.watchLater = watchLater;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public boolean isWatchLater() {
        return watchLater;
    }

    public void setWatchLater(boolean watchLater) {
        this.watchLater = watchLater;
    }
}
