package com.attraya.controller;

import com.attraya.service.MessageRolesDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OllamaAIChatController {

    private final MessageRolesDemoService messageRolesDemoService;

    public OllamaAIChatController(MessageRolesDemoService messageRolesDemoService) {
        this.messageRolesDemoService = messageRolesDemoService;
    }

    @GetMapping("/check/policy")
    public String checkInsurancePolicy(@RequestParam String message) {
        return messageRolesDemoService.checkInsuranceV2Policy(message);
    }


}
