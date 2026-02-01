package com.attraya.controller;

import com.attraya.service.PromptTemplatesDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PromptTemplateChatController {

    private final PromptTemplatesDemoService promptTemplatesDemoService;

    public PromptTemplateChatController(PromptTemplatesDemoService promptTemplatesDemoService) {
        this.promptTemplatesDemoService = promptTemplatesDemoService;
    }

    @GetMapping("/guide")
    public String guideUser(@RequestParam String topic, @RequestParam String level, @RequestParam Integer points) {
        return promptTemplatesDemoService.guideMe(topic, level, points);
    }


}
