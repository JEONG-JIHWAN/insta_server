package com.example.instaserver.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;
import org.springframework.security.core.Authentication;

public final class JwtProvider {

    private final String issuer;
    private final String clientSecret;
    private final int expirySeconds;
    private final Algorithm algorithm;
    private final JWTVerifier jwtVerifier;

    public JwtProvider(String issuer, String clientSecret, int expirySeconds) {
        this.issuer = issuer;
        this.clientSecret = clientSecret;
        this.expirySeconds = expirySeconds;
        this.algorithm = Algorithm.HMAC512(clientSecret);
        this.jwtVerifier = JWT.require(algorithm).withIssuer(issuer).build();
    }

    public String generateToken(Authentication authentication) {
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        Date now = new Date();
        String jwtToken = JWT.create()
                .withIssuer(issuer)
                .withExpiresAt(new Date(now.getTime() + expirySeconds * 1000 * 60))
                .withClaim("nickname", principalDetails.getUsername())
                .sign(algorithm);
        return jwtToken;
    }

    public DecodedJWT verity(String token) throws JWTVerificationException {
        return jwtVerifier.verify(token);
    }

}
