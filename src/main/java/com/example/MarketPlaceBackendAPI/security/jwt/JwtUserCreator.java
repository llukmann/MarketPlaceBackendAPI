package com.example.MarketPlaceBackendAPI.security.jwt;

import com.example.MarketPlaceBackendAPI.models.User;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
public class JwtUserCreator {
    @org.jetbrains.annotations.NotNull
    @org.jetbrains.annotations.Contract("_ -> new")
    public static JwtUser create(@NotNull User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
    }
}
