package com.example.instaserver.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "jwt.token")
public class JwtConfig {
    private String header;
    private String issuer;
    private String clientSecret;
    private int expirySeconds;
}
