package com.example.instaserver.auth;

import com.example.instaserver.user.entity.User;
import com.example.instaserver.user.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {
    private static final String TOKEN_PREFIX = "Bearer";
    private final String headerKey;
    private final JwtProvider jwtProvider;
    private final UserService userService;

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        if(SecurityContextHolder.getContext().getAuthentication() == null) {
            String token = getToken(request);
            if(token != null) {
                String nickname = jwtProvider.verity(token).getClaim("nickname").asString();
                User byNickname = userService.findByNickname(nickname);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(byNickname, null);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        String authorizationToken = request.getHeader(headerKey);
        if (authorizationToken != null){
            return authorizationToken.replace(TOKEN_PREFIX, "");
        }
        return null;
    }
}
