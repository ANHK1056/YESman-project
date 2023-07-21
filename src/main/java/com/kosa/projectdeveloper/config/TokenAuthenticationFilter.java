/*
토큰으로 계정을 인증하는 클래스
 */
package com.kosa.projectdeveloper.config;

import com.kosa.projectdeveloper.config.jwt.TokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {
    //토큰 정보를 가져오는 객체
    private final TokenProvider tokenProvider;


    //인증 객체
    private final static String HEADER_AUTHORIZATION = "Authorization";

    //토큰의 이름
    private final static String TOKEN_PREFIX = "Bearer ";

    //JWT 토큰을 받고 내어보내는 endPoint
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)  throws ServletException, IOException {

        String authorizationHeader = request.getHeader(HEADER_AUTHORIZATION);
        String token = getAccessToken(authorizationHeader);

        if (tokenProvider.validToken(token)) {
            Authentication authentication = tokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    //AccessToken 생성
    private String getAccessToken(String authorizationHeader) {
        //인증해더가 NUll이 아니거나 token_prefix로 시작할 경우 token_prefix를 반환
        if (authorizationHeader != null && authorizationHeader.startsWith(TOKEN_PREFIX)) {
            return authorizationHeader.substring(TOKEN_PREFIX.length());
        }

        return null;
    }
}

