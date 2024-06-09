package com.TRA.tra24Springboot.Services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MailingService {
    private JavaMailSender javaMailSender;

    private String sender;

    public String sendSimpleMail(String receiver, String sender,
                                 String emailBody, String subject ){
        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(receiver);
            mailMessage.setText(emailBody);
            mailMessage.setSubject(subject);
            mailMessage.setSentDate(new Date());
            return "success!";
        } catch (Exception e){
            return "Error!";
        }
    }
}
