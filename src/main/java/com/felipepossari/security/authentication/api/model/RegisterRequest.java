package com.felipepossari.security.authentication.api.model;

public record RegisterRequest(String login, String password, String role) {
}
