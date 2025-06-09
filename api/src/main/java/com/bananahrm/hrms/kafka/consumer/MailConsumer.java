package com.bananahrm.hrms.kafka.consumer;

import com.bananahrm.hrms.Service.emailService.EmailService;
import com.bananahrm.hrms.kafka.dto.MailRequest;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailConsumer {
    private final EmailService emailService;

    @KafkaListener(topics = "email-topic", groupId = "email-group")
    public void listen(MailRequest mailRequest) throws Exception {
        emailService.sendEmail(mailRequest.getTo(), mailRequest.getSubject(), mailRequest.getBody());
    }
}
