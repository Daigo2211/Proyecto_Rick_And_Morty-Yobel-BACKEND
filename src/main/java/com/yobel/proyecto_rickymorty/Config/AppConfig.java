package com.yobel.proyecto_rickymorty.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//Clase para usar RestTemplate de manera global
@Configuration
public class AppConfig {

@Bean
public RestTemplate restTemplate() {
    return new RestTemplate();
}

}


