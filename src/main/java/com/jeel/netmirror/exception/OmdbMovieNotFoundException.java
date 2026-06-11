package com.jeel.netmirror.exception;

public class OmdbMovieNotFoundException extends RuntimeException {
    public OmdbMovieNotFoundException(String message) {
        super(message);
    }
}
