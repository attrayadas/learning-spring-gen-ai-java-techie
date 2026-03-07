package com.attraya.service;

import com.attraya.dto.TripPlan;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.ai.converter.MapOutputConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class TripPlannerService {

    private final ChatClient chatClient;

    @Value("classpath:prompts/trip-guide-template.st")
    private Resource tripGuideTemplate;

    public TripPlannerService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public TripPlan getTripPlans(String message){
        return chatClient
                .prompt()
                .system(tripGuideTemplate)
                .user(message)
                .call()
                .entity(TripPlan.class);
    }

    public List<String> getTripSpots(String message){
        return chatClient
                .prompt()
                .user(message)
                .call()
                .entity(new ListOutputConverter());
    }

    public Map<String, Object> getTripGuide(String message){
        return chatClient
                .prompt()
                .user(message)
                .call()
                .entity(new MapOutputConverter());
    }

    public List<TripPlan> getCompleteTripPlan(String message){
        return chatClient
                .prompt()
                .user(message)
                .call()
                .entity(new ParameterizedTypeReference<List<TripPlan>>() {
                });
    }
}
