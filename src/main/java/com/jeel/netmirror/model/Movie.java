package com.jeel.netmirror.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movies")
public class Movie {
    @Id
    private String id;
    @NotBlank(message = "Title cannot be empty")
    private String title;
    @NotBlank(message = "Genre cannot be empty")
    private String genre;
    private boolean watched;
    private boolean watchLater;

    public Movie(String id, String title, String genre, boolean watched, boolean watchLater) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.watched = watched;
        this.watchLater = watchLater;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
