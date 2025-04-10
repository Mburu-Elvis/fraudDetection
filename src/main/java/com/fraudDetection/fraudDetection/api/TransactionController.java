package com.fraudDetection.fraudDetection.api;

import com.fraudDetection.fraudDetection.config.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1")
public class TransactionController {
    @Autowired
    private MessageProducer messageProducer;

    @PostMapping("/transactions")
    public String processTransaction(@RequestParam("message") String message) {
        messageProducer.sendMessage("fraud-detection", message);
        return "Message sent: " + message;
    }
}
