package com.advancedgym.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AdvancedGymApplication {

    public static void main(String[] args) {
        // Esta línea es la que inicia toda la aplicación de Spring Boot
        SpringApplication.run(AdvancedGymApplication.class, args);
    }

    // Configuración de CORS para permitir peticiones desde el frontend
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                // Permite peticiones a cualquier endpoint de la API ("/api/**")
//                registry.addMapping("/api/**")
//                        // Desde cualquier origen (para desarrollo es más fácil así)
//                        .allowedOrigins("*")
//                        // Permitiendo estos métodos HTTP
//                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
//            }
//        };
//    }
}