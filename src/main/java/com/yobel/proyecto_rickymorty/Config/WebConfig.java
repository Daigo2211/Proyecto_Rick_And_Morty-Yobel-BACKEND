package com.yobel.proyecto_rickymorty.Config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//Aquí se implementa los Cors de manera global para que cualquier parte del proyecto pueda hacer solicitudes al angular
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // Frontend de angular
                .allowedMethods("GET")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}

