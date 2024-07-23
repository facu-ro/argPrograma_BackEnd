

package com.argprograma.argprograma;

import java.util.Properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

//C:\Users\FACU\Desktop\back\argPrograma_BackEnd\src\main\java\com\argprograma\argprograma\controller\Cemail.java
@Configuration
@PropertySource("classpath:email.properties")
public class emailConfig {
    
    @Value("${email.username}")
    private String email;
    
    @Value("${email.password}")
    private String password;
    
    
    private Properties getMailProperties(){
        
        Properties properties=new Properties();
        
        System.out.println(properties.toString()); 
        
        /*properties.put("mail.username","jazminrocio1998@gmail.com");
        properties.put("mail.password", "vxpdhekqynnlmxqv");*/
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Ejemplo: smtp.gmail.com
        properties.put("mail.smtp.port", "587"); // Ejemplo: 587
        
        System.out.println(properties.toString()); 
        
        
        return properties;

    }
    
    
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setJavaMailProperties(getMailProperties());
        mailSender.setUsername(email);
        mailSender.setPassword(password);
        return mailSender;
    }

    @Bean
    public ResourceLoader resourceLoader() {
        return new DefaultResourceLoader();
    }
    
    
}
 