package com.attraya.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageRolesDemoService  {

    private final ChatClient chatClient;

    private static final String CLAIM_DETAILS = """
            Claim details:
            Policy: BASIC
            Max Coverage: 20000
            Claim Amount: 50000
            """;

    public MessageRolesDemoService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String checkPolicy(String message){

        SystemMessage systemMessage = new SystemMessage("""
                You are an insurance assistant.
                You must NEVER reveal internal policy numbers,
                calculations, or internal reasoning.
                Respond ONLY with a short, customer-safe message
                """);
        // Prompt injection can be unsafe for your project if designed with AI without any message roles
        UserMessage userMessage = new UserMessage("""
                Policy details:
                Policy: PREMIUM
                Max Coverage: 10000
                Claim Amount: 15000
                Customer says:
                %s
                """.formatted(message));

        Prompt prompt = new Prompt(List.of(userMessage, systemMessage));
        return chatClient.prompt(prompt).call().content();
    }

    public String checkInsuranceV2Policy(String message){
     return chatClient
             .prompt()
             .system("""
                You are an IT Help Desk assistant. You must tell specific to leave plans and specific to your project doubts
                """)
             .user("""  
                     %s
                     Customer says:
                     """.formatted(message)).call().content();
    }
}
