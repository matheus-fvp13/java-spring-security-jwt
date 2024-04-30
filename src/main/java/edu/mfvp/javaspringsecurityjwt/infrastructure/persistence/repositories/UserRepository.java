package edu.mfvp.javaspringsecurityjwt.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mfvp.javaspringsecurityjwt.infrastructure.persistence.schemas.UserSchema;

public interface UserRepository extends JpaRepository<UserSchema, Long> {
    boolean existsByEmail(String email);
}
