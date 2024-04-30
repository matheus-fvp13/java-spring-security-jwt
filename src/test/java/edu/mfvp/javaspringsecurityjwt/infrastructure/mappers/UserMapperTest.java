package edu.mfvp.javaspringsecurityjwt.infrastructure.mappers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import edu.mfvp.javaspringsecurityjwt.domain.entities.User;
import edu.mfvp.javaspringsecurityjwt.infrastructure.persistence.schemas.UserSchema;

@ExtendWith(MockitoExtension.class)
public class UserMapperTest {

    @InjectMocks
    private UserMapper userMapper;

    @Mock
    private ModelMapper modelMapper;
    
    @Test
    public void shouldBeAbleToConvertAUserSchemaToUser() {
        var source = Instancio.create(UserSchema.class);
        var target = new User(source.getId(), source.getFirstName(), source.getLastName(), 
                source.getEmail(), source.getPassword(), source.getBirthDate());
        when(userMapper.mapUserSchemaToUser(source)).thenReturn(target);

        var result = userMapper.mapUserSchemaToUser(source);
        assertEquals(target, result);
        verifyNoMoreInteractions(modelMapper);
    }

    @Test
    public void shouldBeAbleToConvertAUserToUserSchema() {
        var source = Instancio.create(User.class);
        var target = new UserSchema();

        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setEmail(source.getEmail());
        target.setPassword(source.getPassword());
        target.setBirthDate(source.getBirthDate());

        when(userMapper.mapUserToUserSchema(source)).thenReturn(target);

        var result = userMapper.mapUserToUserSchema(source);
        assertEquals(target, result);
        verifyNoMoreInteractions(modelMapper);
    }

}
