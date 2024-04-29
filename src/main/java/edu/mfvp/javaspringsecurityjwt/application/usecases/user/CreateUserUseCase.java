package edu.mfvp.javaspringsecurityjwt.application.usecases.user;

import edu.mfvp.javaspringsecurityjwt.domain.entities.User;

public interface CreateUserUseCase {
    void execute(User user);
}
