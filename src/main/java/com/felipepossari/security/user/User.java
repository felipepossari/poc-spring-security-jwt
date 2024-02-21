package com.felipepossari.security.user;

import com.felipepossari.security.user.repository.model.UserRole;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class User {

    private String id;
    private String login;
    private String password;
    private UserRole role;
}
