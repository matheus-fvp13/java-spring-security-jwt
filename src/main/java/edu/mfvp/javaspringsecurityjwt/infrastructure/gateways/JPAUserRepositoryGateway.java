package edu.mfvp.javaspringsecurityjwt.infrastructure.gateways;

import edu.mfvp.javaspringsecurityjwt.application.gateways.out.UserRepositoryGateway;
import edu.mfvp.javaspringsecurityjwt.domain.entities.User;
import edu.mfvp.javaspringsecurityjwt.infrastructure.mappers.UserMapper;
import edu.mfvp.javaspringsecurityjwt.infrastructure.persistence.repositories.UserRepository;

public class JPAUserRepositoryGateway implements UserRepositoryGateway {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public JPAUserRepositoryGateway(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void save(User user) {
        var userschema = userMapper.mapUserToUserSchema(user);
        userRepository.save(userschema);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
