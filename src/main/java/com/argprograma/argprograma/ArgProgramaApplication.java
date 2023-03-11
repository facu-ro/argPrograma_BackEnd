package com.argprograma.argprograma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ArgProgramaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArgProgramaApplication.class, args);
                
                
                System.out.println("hola");
                
                
	}
        
        
    @Bean
    public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurer() {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	    registry.addMapping("/**").allowedOrigins("http://localhost:4200")
                    .allowedMethods("*")
                    .allowedHeaders("*");
		
            }
	};
    }

}
