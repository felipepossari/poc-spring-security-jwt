package com.felipepossari.security.authentication;

import com.felipepossari.security.authentication.api.model.RegisterRequest;
import com.felipepossari.security.user.User;
import com.felipepossari.security.user.repository.model.UserEntity;
import com.felipepossari.security.user.repository.model.UserRole;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationBuilder {

    public UserEntity toEntity(RegisterRequest request) {
        return UserEntity.builder()
                .login(request.login())
                .role(UserRole.valueOf(request.role()))
                .build();
    }

    public UserEntity toEntity(String login, String passwordEncrypted, String role) {
        return UserEntity.builder()
                .login(login)
                .password(passwordEncrypted)
                .role(UserRole.valueOf(role))
                .build();
    }

    public User toUser(UserEntity entity){
        return User.builder()
                .id(entity.getId())
                .role(entity.getRole())
                .login(entity.getLogin())
                .build();
    }
}
