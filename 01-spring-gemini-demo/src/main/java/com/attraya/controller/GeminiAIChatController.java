package com.attraya.controller;

import com.attraya.service.GeminiAIChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geminiai/api")
public class GeminiAIChatController {

    private final GeminiAIChatService geminiAIChatService;

    public GeminiAIChatController(GeminiAIChatService geminiAIChatService) {
        this.geminiAIChatService = geminiAIChatService;
    }

    @GetMapping
    public String chat(@RequestParam String message) {
        return geminiAIChatService.chatWithOpenAILLM(message);
    }


}
