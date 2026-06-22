package com.jeel.netmirror.repository;

import com.jeel.netmirror.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String>{
    Optional<User> findFirstByEmail(String email);

    boolean existsByEmail(String email);
}
