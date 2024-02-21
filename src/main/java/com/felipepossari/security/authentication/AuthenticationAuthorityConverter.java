package com.felipepossari.security.authentication;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class AuthenticationAuthorityConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        String role = jwt.getClaimAsString("role");
        if (StringUtils.hasText(role)) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return new JwtAuthenticationToken(jwt, grantedAuthorities);
    }
}
