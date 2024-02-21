package com.felipepossari.security.authentication;

import com.felipepossari.security.authentication.api.model.RegisterRequest;
import com.felipepossari.security.user.repository.UserRepository;
import com.felipepossari.security.user.repository.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationBuilder builder;
    private final TokenService tokenService;

    public String authenticate(UsernamePasswordAuthenticationToken token) {
        var auth = authenticationManager.authenticate(token);
        return tokenService.generateToken(builder.toUser((UserEntity) auth.getPrincipal()));
    }

    public void register(RegisterRequest body) {
        var userOpt = userRepository.findByLogin(body.login());
        if (userOpt.isPresent()) {
            // TODO: Throw proper exception
            throw new RuntimeException("Login already registered");
        }

        var passwordEncrypted = passwordEncoder.encode(body.password());
        var userEntity = builder.toEntity(body.login(), passwordEncrypted, body.role());
        userRepository.save(userEntity);
    }
}
