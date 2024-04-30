package edu.mfvp.javaspringsecurityjwt.infrastructure.config;

import edu.mfvp.javaspringsecurityjwt.application.gateways.out.UserRepositoryGateway;
import edu.mfvp.javaspringsecurityjwt.application.usecases.user.CreateUserUseCase;
import edu.mfvp.javaspringsecurityjwt.application.usecases.user.impl.CreateUserUseCaseImpl;
import edu.mfvp.javaspringsecurityjwt.infrastructure.gateways.JPAUserRepositoryGateway;
import edu.mfvp.javaspringsecurityjwt.infrastructure.mappers.UserMapper;
import edu.mfvp.javaspringsecurityjwt.infrastructure.persistence.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    private final ModelMapper modelMapper;

    public UserConfig(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Bean
    CreateUserUseCase getCreateUserUseCase(UserRepositoryGateway userRepositoryGateway) {
        return new CreateUserUseCaseImpl(userRepositoryGateway);
    }

    @Bean
    UserRepositoryGateway getUserRepositoryGateway(UserRepository userRepository) {
        return new JPAUserRepositoryGateway(userRepository, getUserMapper(modelMapper));
    }

    @Bean
    UserMapper getUserMapper(ModelMapper modelMapper) {
        return new UserMapper(modelMapper);
    }
}
