package edu.mfvp.javaspringsecurityjwt.infrastructure.api.dtos.request;

import edu.mfvp.javaspringsecurityjwt.domain.entities.User;

import java.time.LocalDate;

public record UserRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        LocalDate birthDate
) {
    public User toUser() {
        return new User(null, firstName, lastName, email, password, birthDate);
    }

    public static UserRequest fromUser(User user) {
        return new UserRequest(user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getPassword(), user.getBirthDate());
    }
}
