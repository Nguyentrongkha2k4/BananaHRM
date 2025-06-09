package com.bananahrm.hrms.kafka.producer;

import com.bananahrm.hrms.kafka.dto.MailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void send(MailRequest mailRequest) {
        kafkaTemplate.send("email-topic", mailRequest);
    }
}
