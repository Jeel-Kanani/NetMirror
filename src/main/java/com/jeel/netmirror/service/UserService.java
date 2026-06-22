package com.jeel.netmirror.service;

import com.jeel.netmirror.model.User;
import com.jeel.netmirror.repository.UserRepository;
import com.jeel.netmirror.exception.EmailAlreadyExistsException;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,BCryptPasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException(user.getEmail());
        }

        user.setRole("USER");
        user.setPassword(
                passwordEncoder.encode(
                        user.getPassword()));
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findFirstByEmail(email)
                .orElse(null);
    }

    public boolean verifyPassword(
            String rawPassword,
            String hashedPassword) {

        return passwordEncoder.matches(
                rawPassword,
                hashedPassword);
    }
}
