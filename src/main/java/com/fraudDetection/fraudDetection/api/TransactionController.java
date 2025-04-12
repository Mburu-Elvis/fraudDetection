package com.fraudDetection.fraudDetection.api;

import com.fraudDetection.fraudDetection.config.MessageProducer;
import com.fraudDetection.fraudDetection.dto.TransationRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
public class TransactionController {
    @Autowired
    private MessageProducer messageProducer;

    @PostMapping("/transactions")
    public ResponseEntity<?> processTransaction(@Valid @RequestBody TransationRequest transationRequest) {
        messageProducer.sendTransaction(transationRequest);
        return ResponseEntity.ok("Transaction received and pushed to Kafka");
    }
}
