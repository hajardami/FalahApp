package com.backFalahApp.BackFalahApp.service;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    private JavaMailSender mailSender;

    public EmailSenderService(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }

    public void sendSimpleEmail(
            String toEmail,
            String body,
            String subject
    ) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("kaixokoko1@gmail.com");
        msg.setTo(toEmail);
        msg.setSubject(subject);
        msg.setText(body);

        mailSender.send(msg);
    }
}
