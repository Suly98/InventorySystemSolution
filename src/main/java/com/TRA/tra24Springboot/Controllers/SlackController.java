package com.TRA.tra24Springboot.Controllers;

import com.TRA.tra24Springboot.Services.SlackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Slack")
public class SlackController {

    @Autowired
    SlackService slackService;

    @Scheduled(cron = "* * * * * ?")
    @PostMapping("m")
    public void sendMessage(){
        slackService.sendMessage("pry","hello");
    }
}
