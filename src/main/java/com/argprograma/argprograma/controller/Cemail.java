

package com.argprograma.argprograma.controller;

import com.argprograma.argprograma.model.CorreoRequest;
import com.argprograma.argprograma.service.IEmailService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*@RequestMapping
@CrossOrigin("*")*/
public class Cemail {

    @Autowired
    IEmailService emailService;

    @PostMapping("/enviar-correo")
    public ResponseEntity<Map<String, String>> enviarCorreo(@RequestBody CorreoRequest correoRequest) {
         Map<String, String> response = new HashMap<>();
        try {
            emailService.enviarCorreo(correoRequest);
            response.put("message", "Correo enviado exitosamente.");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("message", "Error al enviar el correo: " + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}