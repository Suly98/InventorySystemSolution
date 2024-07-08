package com.TRA.tra24Springboot.Services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.FileSystem;
import java.util.Date;

@Service
public class MailingService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sender;

    //to send emails
    public String sendSimpleMail(String receiver, String sender,
                                 String emailBody, String subject ){
        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(receiver);
            mailMessage.setText(emailBody);
            mailMessage.setSubject(subject);
            mailMessage.setSentDate(new Date());
            javaMailSender.send(mailMessage);
            return "success!";
        } catch (Exception e){
            return "Error!";
        }
    }

    //to send email with attachment!
    public String sendMailWithAttachment(){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper;

        try{
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo("email");
            mimeMessageHelper.setText("Text");
            mimeMessageHelper.setSubject("Subject");

            FileSystemResource file = new FileSystemResource(new File("Path to local file"));
            mimeMessageHelper.addAttachment(file.getFilename(), file);
            javaMailSender.send(mimeMessage);
            return "Success!";

        } catch (MessagingException e){
            return "Error";
        }
    }
}
