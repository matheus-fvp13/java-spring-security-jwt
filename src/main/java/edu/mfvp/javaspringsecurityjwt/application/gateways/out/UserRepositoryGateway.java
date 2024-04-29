package edu.mfvp.javaspringsecurityjwt.application.gateways.out;

import edu.mfvp.javaspringsecurityjwt.domain.entities.User;

public interface UserRepositoryGateway {
    void save(User user);
    boolean existsByEmail(String email);
}
