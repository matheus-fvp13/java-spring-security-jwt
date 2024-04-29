package edu.mfvp.javaspringsecurityjwt.application.usecases.user.impl;

import edu.mfvp.javaspringsecurityjwt.application.gateways.out.UserRepositoryGateway;
import edu.mfvp.javaspringsecurityjwt.application.usecases.user.CreateUserUseCase;
import edu.mfvp.javaspringsecurityjwt.domain.entities.User;
import edu.mfvp.javaspringsecurityjwt.domain.exceptions.UserEmailAlreadyExistsException;

public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private UserRepositoryGateway repositoryGateway;

    @Override
    public void execute(User user) {
        if(repositoryGateway.existsByEmail(user.getEmail())) {
            throw new UserEmailAlreadyExistsException(user.getEmail());
        }

        repositoryGateway.save(user);
    }

}
