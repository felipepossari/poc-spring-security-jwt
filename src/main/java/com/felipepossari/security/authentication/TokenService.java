package com.felipepossari.security.authentication;

import com.felipepossari.security.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class TokenService {

    public static final String ISSUER = "poc-jwt-api";

    private final JwtEncoder jwtEncoder;

    public String generateToken(User user) {
        Instant now = Instant.now();

        var claims = JwtClaimsSet.builder()
                .issuer(ISSUER)
                .issuedAt(now)
                .expiresAt(now.plusSeconds(10L))
                .subject(user.getLogin())
                .claim("id", user.getId())
                .claim("role", user.getRole())
                .claim("scope", user.getRole())
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

}
