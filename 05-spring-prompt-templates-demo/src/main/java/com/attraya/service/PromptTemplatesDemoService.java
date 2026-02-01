package com.attraya.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
/*
Not a good approach to use prompt in service class and doing string concatenation
 */
@Service
public class PromptTemplatesDemoService {

    private final ChatClient chatClient;

    public PromptTemplatesDemoService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String guideMe(String topic, String level, int points){
        return chatClient
                .prompt()
                .system("You are a tech stack assistant." +
                        "give best answer to the students and make sure your answer will be to the point")
                .user("Explain me " +topic+ " in "+level+" level with "+points+"+ points only")
                .call().content();
    }
}
