package com.yobel.proyecto_rickymorty.Config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Desactiva la protección CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()  // Permite todas las solicitudes sin autenticación
                )
                .formLogin(form -> form.disable())  // Desactiva el formulario de login
                .httpBasic(httpBasic -> httpBasic.disable());  // Desactiva la autenticación básica

        return http.build();
    }
}
