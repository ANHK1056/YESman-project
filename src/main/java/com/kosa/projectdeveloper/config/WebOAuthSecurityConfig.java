/*
로그인, OAuth2 로그인을 구성하는 클래스
 */
package com.kosa.projectdeveloper.config;

import com.kosa.projectdeveloper.config.jwt.TokenProvider;
import com.kosa.projectdeveloper.config.oauth.OAuth2AuthorizationRequestBasedOnCookieRepository;
import com.kosa.projectdeveloper.config.oauth.OAuth2SuccessHandler;
import com.kosa.projectdeveloper.config.oauth.OAuth2UserCustomService;
import com.kosa.projectdeveloper.repository.RefreshTokenRepository;
import com.kosa.projectdeveloper.service.UserDetailService;
import com.kosa.projectdeveloper.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//AWS 사용으로 제거
//import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@RequiredArgsConstructor
@Configuration
public class WebOAuthSecurityConfig {

    private final OAuth2UserCustomService oAuth2UserCustomService;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserService userService;

    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring()
                // TODO: 2023-07-12 aws 데이터베이스 사용시 주석
//               .requestMatchers(toH2Console())
               .requestMatchers("/img/**", "/css/**", "/js/**", "/api/**");
//             .requestMatchers("/**");

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //로그인에서는 방어를 해제
        http.csrf().disable()
                .httpBasic().disable()
                .logout().disable();

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);


        http.authorizeRequests()
                //인증없이 들어갈 수 있는 주소
                .requestMatchers("/api/token","/login","/signup","/users", "/**").permitAll()
//                .requestMatchers("/api/**").authenticated()
                .anyRequest().permitAll();


        //OAuth2 로그인
        http.oauth2Login()
                .loginPage("/login")
                .authorizationEndpoint()
                .authorizationRequestRepository(oAuth2AuthorizationRequestBasedOnCookieRepository())
                .and()
                .successHandler(oAuth2SuccessHandler())
                .userInfoEndpoint()
                .userService(oAuth2UserCustomService);
        //로그인 폼폼
        http.formLogin()
                .loginPage("/login")
               .defaultSuccessUrl("/loginHome/10")
//                .successHandler(oAuth2SuccessHandler())
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true);

        http.logout()
                .logoutSuccessUrl("/");


        http.exceptionHandling()
                .defaultAuthenticationEntryPointFor(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED),
                        new AntPathRequestMatcher("/api/**"));


        return http.build();
    }

      @Bean
     public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder,
                                                        UserDetailService userDetailService)
         throws  Exception {
         return http.getSharedObject(AuthenticationManagerBuilder.class)
                 .userDetailsService(userDetailService)
                 .passwordEncoder(bCryptPasswordEncoder)
                 .and()
                 .build();
     }

    @Bean
    public OAuth2SuccessHandler oAuth2SuccessHandler() {
        return new OAuth2SuccessHandler(tokenProvider,
                refreshTokenRepository,
                oAuth2AuthorizationRequestBasedOnCookieRepository(),
                userService
        );
    }

    @Bean
    public TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter(tokenProvider);
    }

    @Bean
    public OAuth2AuthorizationRequestBasedOnCookieRepository oAuth2AuthorizationRequestBasedOnCookieRepository() {
        return new OAuth2AuthorizationRequestBasedOnCookieRepository();
    }

    //password를 복호화
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
