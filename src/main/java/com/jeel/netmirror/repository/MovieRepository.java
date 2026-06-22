package com.jeel.netmirror.repository;

import com.jeel.netmirror.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String>{
}
