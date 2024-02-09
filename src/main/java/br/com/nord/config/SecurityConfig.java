package br.com.nord.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String[] AUTH_WHITELIST = {
        "/configuration/ui",
        "/csrf",
        "/configuration/security",
        "/webjars/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorize ->
                        authorize.requestMatchers(AUTH_WHITELIST)
                                .permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/v1/user").hasAuthority("ADMIN")
                                .requestMatchers(HttpMethod.POST, "/api/v1/user").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/api/v1/user/**").hasAuthority("ADMIN")
                                .anyRequest()
                                .authenticated())
                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .build();

    }

}
