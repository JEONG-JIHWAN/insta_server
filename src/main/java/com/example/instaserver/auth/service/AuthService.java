package com.example.instaserver.auth.service;

import com.example.instaserver.auth.JwtProvider;
import com.example.instaserver.auth.PrincipalDetails;
import com.example.instaserver.auth.controller.dto.SignInRequest;
import com.example.instaserver.auth.controller.dto.SignInResponse;
import com.example.instaserver.user.entity.User;
import com.example.instaserver.user.repository.UserRepository;
import com.example.instaserver.user.service.UserService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserService userService;

    public SignInResponse login(SignInRequest signInRequest){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(signInRequest.getNickname(), signInRequest.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        return new SignInResponse(jwtProvider.generateToken(authentication), jwtProvider.generateToken(authentication));
    }

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        Optional<User> byNickname = userRepository.findByNickname(nickname);
        if(byNickname.isEmpty()){
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        return new PrincipalDetails(byNickname.get());
    }
}
