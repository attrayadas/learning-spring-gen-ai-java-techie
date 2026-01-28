package com.attraya.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeminiAIChatService {

    private final ChatClient chatClient;

    public GeminiAIChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String chatWithOpenAILLM(String message){
        return chatClient.prompt(message).call().content();
    }
}
