package edu.mfvp.javaspringsecurityjwt.application.usecases.user;

import static org.mockito.Mockito.when;

import org.instancio.Instancio;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import edu.mfvp.javaspringsecurityjwt.application.gateways.out.UserRepositoryGateway;
import edu.mfvp.javaspringsecurityjwt.application.usecases.user.impl.CreateUserUseCaseImpl;
import edu.mfvp.javaspringsecurityjwt.domain.entities.User;
import edu.mfvp.javaspringsecurityjwt.domain.exceptions.UserEmailAlreadyExistsException;

@ExtendWith(MockitoExtension.class)
public class CreateUserUseCaseTest {
    @InjectMocks
    private CreateUserUseCaseImpl useCase;

    @Mock
    private UserRepositoryGateway userRepository;

    @Test
    public void shouldBeAbleToCreateAUserIfEmailNotExists() {
        User user = Instancio.create(User.class);
        when(userRepository.existsByEmail(user.getEmail())).thenReturn(false);

        useCase.execute(user);

        verify(userRepository).existsByEmail(user.getEmail());
        verify(userRepository).save(user);
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void shouldNotBeAbleToCreateAUserIfEmailExists() {
        User user = Instancio.create(User.class);
        when(userRepository.existsByEmail(user.getEmail())).thenReturn(true);

        assertThrows(UserEmailAlreadyExistsException.class, () -> useCase.execute(user));

        verify(userRepository).existsByEmail(user.getEmail());
        verifyNoMoreInteractions(userRepository);
    }
}
