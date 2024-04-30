package edu.mfvp.javaspringsecurityjwt.infrastructure.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import edu.mfvp.javaspringsecurityjwt.domain.entities.User;
import edu.mfvp.javaspringsecurityjwt.infrastructure.persistence.schemas.UserSchema;

@Component
public class UserMapper {
    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public User mapUserSchemaToUser(UserSchema userSchema) {
        return modelMapper.map(modelMapper, User.class);
    }

    public UserSchema mapUserToUserSchema(User user) {
        return modelMapper.map(user, UserSchema.class);
    }
}
