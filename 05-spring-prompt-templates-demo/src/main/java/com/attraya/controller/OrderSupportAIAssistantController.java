package com.attraya.controller;

import com.attraya.service.OrderSupportAIAssistantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderSupportAIAssistantController {

    private final OrderSupportAIAssistantService orderSupportAIAssistantService;

    public OrderSupportAIAssistantController(OrderSupportAIAssistantService orderSupportAIAssistantService) {
        this.orderSupportAIAssistantService = orderSupportAIAssistantService;
    }

    @GetMapping("/order-support")
    public String getOrderSupportResponse(@RequestParam String customerName, @RequestParam String orderId, @RequestParam String customerMessage){
        return orderSupportAIAssistantService.assistWithOrderSupport(customerName, orderId, customerMessage);
    }

    @GetMapping("/order-ai-support")
    public String talkToOrderAISupport(@RequestParam String customerName, @RequestParam String orderId, @RequestParam String customerMessage){
        return orderSupportAIAssistantService.talkToAISupport(customerName, orderId, customerMessage);
    }
}
