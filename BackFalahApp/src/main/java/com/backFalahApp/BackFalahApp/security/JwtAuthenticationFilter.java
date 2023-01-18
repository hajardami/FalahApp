package com.backFalahApp.BackFalahApp.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private JwtLogin credentials;
    private ObjectMapper mapper;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        this.mapper = new ObjectMapper();
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("db he attempts");

        try {

            credentials = mapper.readValue(request.getInputStream(), JwtLogin.class);

        } catch (IOException e) {
            return null;
        }

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                credentials.getEmail(),
                credentials.getPassword()
        );

        System.out.println(authToken);
        Authentication auth = authenticationManager.authenticate(authToken);

        return auth;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {

        UserPrincipal principal = (UserPrincipal) authResult.getPrincipal();

        String jwtToken = JWT.create()
                .withSubject(principal.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(JwtProperties.SECRET));

        response.setContentType("application/json");

        response.getOutputStream().write(mapper.writeValueAsBytes(Map.of(principal.getAuthorities(),new JwtToken(JwtProperties.TOKEN_PREFIX + jwtToken))));
//        response.getOutputStream().write(mapper.writeValueAsBytes(new JwtToken(JwtProperties.TOKEN_PREFIX + jwtToken)));
    }
}
