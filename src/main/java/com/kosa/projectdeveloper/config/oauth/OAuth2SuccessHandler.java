/*
OAuth2 로그인 성공시 나타나는 클래스
 */
package com.kosa.projectdeveloper.config.oauth;

import com.kosa.projectdeveloper.config.jwt.TokenProvider;
import com.kosa.projectdeveloper.domain.RefreshToken;
import com.kosa.projectdeveloper.domain.User;
import com.kosa.projectdeveloper.repository.RefreshTokenRepository;
import com.kosa.projectdeveloper.service.UserService;
import com.kosa.projectdeveloper.util.CookieUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.time.Duration;

@RequiredArgsConstructor
@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    //쿠키의 이름을 설정
    public static final String REFRESH_TOKEN_COOKIE_NAME = "refresh_token";
    //토큰의 지속 시간
    public static final Duration REFRESH_TOKEN_DURATION = Duration.ofDays(14);
    //접근하는 토큰의 지속시간
    public static final Duration ACCESS_TOKEN_DURATION = Duration.ofDays(1);
    //로그인 성공시 경로
    public static final String REDIRECT_PATH = "/loginHome";
    //유저 정보를 불러오는 객체
    private final TokenProvider tokenProvider;
    //토큰을 저장하는 객체
    private final RefreshTokenRepository refreshTokenRepository;
    //쿠키를 저장하는 객체
    private final OAuth2AuthorizationRequestBasedOnCookieRepository authorizationRequestRepository;
    //사용자 정보를 저장하는 객체
    private final UserService userService;

    //OAuth2 로그인 성공시 불러오는 메서드
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        //OAuth2의 객체를 인증 객체에서 불러옴
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        //OAuth2의 이메일을 유저 객체의 이메일에 저장
        User user = userService.findByUserEmail((String) oAuth2User.getAttributes().get("email"));
        //Refresh토큰 생성
        String refreshToken = tokenProvider.generateToken(user, REFRESH_TOKEN_DURATION);
        //토큰 저장
        saveRefreshToken(user.getUserId(), refreshToken);
        //쿠키 생성
        addRefreshTokenToCookie(request, response, refreshToken);


        //accessToken 생성
        String accessToken = tokenProvider.generateToken(user, ACCESS_TOKEN_DURATION);

        //로그인 성공시 나오는 Url 설정
        String targetUrl = getTargetUrl(user.getUserId());
        //인증 객체를 초기화
        clearAuthenticationAttributes(request, response);
        //로그인 성공시 보내는 요청
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    //RefreshToken을 저장
    private void saveRefreshToken(Long userId, String newRefreshToken) {
        RefreshToken refreshToken = refreshTokenRepository.findByUserId(userId)
                .map(entity -> entity.update(newRefreshToken))
                .orElse(new RefreshToken(userId, newRefreshToken));

        refreshTokenRepository.save(refreshToken);
    }

    //Refresh 토큰 쿠키 생성
    private void addRefreshTokenToCookie(HttpServletRequest request, HttpServletResponse response, String refreshToken) {
        int cookieMaxAge = (int) REFRESH_TOKEN_DURATION.toSeconds();

        CookieUtil.deleteCookie(request, response, REFRESH_TOKEN_COOKIE_NAME);
        CookieUtil.addCookie(response, REFRESH_TOKEN_COOKIE_NAME, refreshToken, cookieMaxAge);
    }

    //인증 요청 정보를 초기화
    private void clearAuthenticationAttributes(HttpServletRequest request, HttpServletResponse response) {
        super.clearAuthenticationAttributes(request);
        authorizationRequestRepository.removeAuthorizationRequestCookies(request, response);
    }

    //url 설정
    private String getTargetUrl(Long userId) {
        return UriComponentsBuilder.fromUriString(REDIRECT_PATH)
                .path("/"+ String.valueOf(userId))
                .build()
                .toUriString();
    }
}
