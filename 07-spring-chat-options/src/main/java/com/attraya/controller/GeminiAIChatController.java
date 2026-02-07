package com.attraya.controller;

import com.attraya.service.OllamaAIChatService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;

@RestController
@RequestMapping("/ollama/api")
public class GeminiAIChatController {

    private final OllamaAIChatService ollamaAIChatService;

    public GeminiAIChatController(OllamaAIChatService ollamaAIChatService) {
        this.ollamaAIChatService = ollamaAIChatService;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String message) {
        return ollamaAIChatService.chatWithOpenAILLM(message);
    }

    @GetMapping(value = "/chat-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> chatStream(@RequestParam String message) {
        return ollamaAIChatService.askToAIStream(message);
    }


}
