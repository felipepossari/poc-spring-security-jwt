package com.felipepossari.security.user;

import com.felipepossari.security.user.repository.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserBuilder {

    public User toUser(UserEntity userEntity){
        return User.builder()
                .id(userEntity.getId())
                .login(userEntity.getLogin())
                .role(userEntity.getRole())
                .build();
    }
}
