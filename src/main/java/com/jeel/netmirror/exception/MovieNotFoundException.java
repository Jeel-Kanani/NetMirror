package com.jeel.netmirror.exception;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(String id) {
        super("Movie with id " + id + " not found");
    }

}
