

package com.argprograma.argprograma.service;

import com.argprograma.argprograma.model.CorreoRequest;

public interface IEmailService {
    void enviarCorreo(CorreoRequest correoRequest);
}