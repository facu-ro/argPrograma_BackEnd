

package com.argprograma.argprograma.service;


import com.argprograma.argprograma.model.CorreoRequest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements IEmailService {
    private final JavaMailSender javaMailSender;
   

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
        
    }

    @Override
    public void enviarCorreo(CorreoRequest correoRequest) {
        try {
            MimeMessage message = this.javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            
            //correoRequest.getDestinatario()
            System.out.println(correoRequest.getDestinatario());
            helper.setReplyTo("jazminrocio@gmail.com");
            //helper.setFrom(correoRequest.getDestinatario());  //"jazminrocio1998@gmail.com"
            helper.setTo("95.rodriguez.facundo@gmail.com");
            helper.setSubject(correoRequest.getAsunto()); //"probando email java"
           
            // Procesar la plantilla Thymeleaf
           /* Context context = new Context();
            context.setVariable("mensaje", correoRequest.getMensaje());
            String contenidoHtml = templateEngine.process("email", context);

            helper.setText(contenidoHtml, true); */
            correoRequest.setMensaje("Enviado desde: " + correoRequest.getDestinatario() + ". \n" + correoRequest.getMensaje() );
            helper.setText(correoRequest.getMensaje(), true);
            this.javaMailSender.send(message);
        
        } catch (Exception e) {
            throw new RuntimeException("Error al enviar el correo: " + e.getMessage(), e);
        }
    }
}