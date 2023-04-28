package com.argprograma.argprograma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ArgProgramaApplication {

	public static void main(String[] args) {
                
       //        System.setProperty("spring.devtools.restart.enabled", "false");
           
                
                SpringApplication.run(ArgProgramaApplication.class, args);
                
                
                System.out.println("hola");
                
                
	}
        
        //"http://localhost:4200"
    @Bean
    public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurer() {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	    registry.addMapping("/**").allowedOrigins("https://mi-portfolio-front.web.app")
                    .allowedMethods("*")
                    .allowedHeaders("*");
		
            }
	};
    }

}
