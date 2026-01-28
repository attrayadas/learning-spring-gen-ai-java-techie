package com.attraya.controller;

import com.attraya.service.OllamaAIChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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


}
