package com.mcuneytozturk.saglikturizmi.configuration;

import com.mcuneytozturk.saglikturizmi.database.repository.UserRepository;
import com.mcuneytozturk.saglikturizmi.util.security.JWTFilter;
import com.mcuneytozturk.saglikturizmi.util.security.SecurityService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private final UserRepository userRepository;
    private final JWTFilter jwtFilter;
    private final SecurityService securityService;

    public SecurityConfiguration(UserRepository userRepository, JWTFilter jwtFilter, SecurityService securityService) {
        this.userRepository = userRepository;
        this.jwtFilter = jwtFilter;
        this.securityService = securityService;
    }

    private static final String[] AUTH_WHITELIST = {
            "/auth/**",
            "/swagger-ui/**",
            "v3/api-docs/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**",
            "/api/public/**",
            "/api/public/authenticate",
            "/actuator/*",
            "/swagger-ui/**"
    };


    private static final String[] USER_AUTH_WHITELIST = {
            "/doctor",
            "/hospital",
            "/flight",
            "/hotel",
            "/room"
    };

    private static final String[] PATIENT_AUTH_WHITELIST = {
            "/appointment",
            "/reservation",
            "/report"
    };

    private static final String[] ADMIN_AUTH_WHITELIST = {
            "/**"
    };
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("security");
        http.headers(Customizer.withDefaults());
        http.csrf(Customizer.withDefaults())
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(AUTH_WHITELIST).permitAll()
                        .requestMatchers(USER_AUTH_WHITELIST).hasRole("user")
                        .requestMatchers(PATIENT_AUTH_WHITELIST).hasRole("patient")
                        .requestMatchers(ADMIN_AUTH_WHITELIST).hasRole("admin")
                        .anyRequest().authenticated()
                )
                .userDetailsService(securityService)
                .exceptionHandling(Customizer.withDefaults())
                .sessionManagement(session -> session.maximumSessions(1));


        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
