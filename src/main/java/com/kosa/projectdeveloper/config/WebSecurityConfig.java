
// package com.kosa.projectdeveloper.config;

// import com.kosa.projectdeveloper.service.UserDetailService;
// import lombok.RequiredArgsConstructor;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

// @RequiredArgsConstructor
// @Configuration
// public class WebSecurityConfig {

//     private  final UserDetailService userService;
//     @Bean
//     public WebSecurityCustomizer configure() {
//         return  (web) -> web.ignoring()
//                 .requestMatchers(toH2Console())
//                 .requestMatchers("/static/**")
//                 // TODO: 2023-07-06 개발 편의를 위해 로그인 리다이렉트 모두 비활성화 
//                 .requestMatchers("/**");
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         return  http
//                 .authorizeHttpRequests()
//                 .requestMatchers("/login","/signup","/user").permitAll()
//                 .anyRequest().authenticated()
//                 .and()
//                 .formLogin()
//                 .loginPage("/login")
// //                .defaultSuccessUrl("/a")
//                 .and()
//                 .logout()
//                 .logoutSuccessUrl("/login")
//                 .invalidateHttpSession(true)
//                 .and()
//                 .csrf().disable()
//                 .build();

//     }

//     @Bean
//     public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder,
//                                                        UserDetailService userDetailService)
//         throws  Exception {
//         return http.getSharedObject(AuthenticationManagerBuilder.class)
//                 .userDetailsService(userService)
//                 .passwordEncoder(bCryptPasswordEncoder)
//                 .and()
//                 .build();
//     }
//     @Bean
//     public BCryptPasswordEncoder bCryptPasswordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

// }
