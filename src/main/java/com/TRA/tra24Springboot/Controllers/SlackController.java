package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Services.MailingService;
import com.TRA.tra24Springboot.Services.SlackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("slack")
public class SlackController {

    @Autowired
    SlackService slackService;

    @Autowired
    MailingService mailingService;

//    @Scheduled(cron = "* * * * * ?")
//    @PostMapping("m")
//    public void sendMessage(){
//        slackService.sendMessage("pry","hello");
//    }

    // this is to send emails
//    @GetMapping("get")
//    public String sendMail(String receiver, String sender,
//                         String emailBody, String subject){
//        mailingService.sendSimpleMail(receiver, sender,
//                emailBody, subject );
//        return "Success";
//    }
}




