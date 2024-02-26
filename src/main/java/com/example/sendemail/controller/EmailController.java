package com.example.sendemail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

// Controlador Spring para manipular solicitações HTTP
@Controller
public class EmailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/sendEmail")
    @ResponseBody
    public String sendEmail(@RequestParam("email") String email) {
        // Lógica para enviar o e-mail para o endereço fornecido
        sendConfirmationEmail(email);
        return "E-mail enviado com sucesso para " + email;
    }

    @Async
    public void sendConfirmationEmail(String email) {
        try {
            // Simula um tempo de espera antes de enviar o e-mail de confirmação
            TimeUnit.SECONDS.sleep(5);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Confirmação de E-mail");
            message.setText("Obrigado por fornecer seu endereço de e-mail! Você receberá um e-mail em breve.");

            javaMailSender.send(message);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
