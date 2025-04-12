package com.fraudDetection.fraudDetection.config;

import com.fraudDetection.fraudDetection.dto.TransationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    private static final String TOPIC = "fraud-detection";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendTransaction(TransationRequest transationRequest) {
        kafkaTemplate.send(TOPIC, transationRequest.getTransactionId(), transationRequest);
    }
}
