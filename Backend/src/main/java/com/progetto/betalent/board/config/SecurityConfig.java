package com.progetto.betalent.board.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

//    @Autowired
//    CustomUserDetailsService customUserDetailsService;
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http.csrf().disable().authorizeHttpRequests()
//
//
//                .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
//                .requestMatchers(new AntPathRequestMatcher("/login")).permitAll()
//                .requestMatchers(new AntPathRequestMatcher("/rest/**")).permitAll()
//                .requestMatchers(new AntPathRequestMatcher("/register")).permitAll()
//                .requestMatchers(new AntPathRequestMatcher("/home")).permitAll().and()
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/login")
//                .defaultSuccessUrl("/home", true).permitAll()
//                .and()
//                .logout()
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/login?logout").permitAll();
//        return http.build();
//
//
//    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws  Exception{
//        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
//    }
}
