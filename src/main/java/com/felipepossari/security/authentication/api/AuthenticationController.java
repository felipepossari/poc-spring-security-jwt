package com.felipepossari.security.authentication.api;

import com.felipepossari.security.authentication.AuthenticationService;
import com.felipepossari.security.authentication.api.model.LoginRequest;
import com.felipepossari.security.authentication.api.model.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest body) {
        var token = service.authenticate(new UsernamePasswordAuthenticationToken(body.login(), body.password()));
        return ResponseEntity
                .ok()
                .header("token", token)
                .build();
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequest body) {
        service.register(body);
        return ResponseEntity.ok().build();
    }
}
