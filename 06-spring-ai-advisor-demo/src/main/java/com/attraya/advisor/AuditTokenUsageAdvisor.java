package com.attraya.advisor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;
import org.springframework.ai.chat.metadata.Usage;
import org.springframework.ai.chat.model.ChatResponse;

public class AuditTokenUsageAdvisor implements CallAdvisor {
    
    Logger logger = LoggerFactory.getLogger(AuditTokenUsageAdvisor.class);
    
    @Override
    public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain) {
        // Call the next advisor/LLM
        ChatClientResponse chatClientResponse = callAdvisorChain.nextCall(chatClientRequest);

        ChatResponse chatResponse = chatClientResponse.chatResponse();
        if (chatResponse != null){
            Usage usage = chatResponse.getMetadata().getUsage();
            // Audit token usage here
            if(usage != null){
                // Extract (i/p token, o/p token, total token)
                Integer inputTokens = usage.getPromptTokens();
                Integer outputToken = usage.getCompletionTokens();
                Integer totalTokens = usage.getTotalTokens();

                // log those details
                logger.info("Token Usage - input tokens: {}, output tokens: {}, total tokens: {}", inputTokens, outputToken, totalTokens);

            }
        }
        return chatClientResponse;
    }

    @Override
    public String getName() {
        return "AuditTokenUsageAdvisor";
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
