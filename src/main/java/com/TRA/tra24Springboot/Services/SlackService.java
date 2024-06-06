package com.TRA.tra24Springboot.Services;

import com.slack.api.Slack;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;
import com.slack.api.methods.response.chat.ChatPostMessageResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SlackService {


    @Value("${slack.token}")
    private String slackToken;

    public void sendMessage(String channel, String message) {
        Slack slack = Slack.getInstance();
        String token = slackToken; // Your Slack API token




        ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                .channel(channel)
                .text(message)
                .build();

        try {
            slack.methods(token).chatPostMessage(request);

        } catch (Exception e) {
            System.out.println("Error sending message to Slack: " + e.getMessage());
        }
    }
}