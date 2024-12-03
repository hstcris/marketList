package com.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.stereotype.Service;

@Service
public class PulsarPublisher {

    @Autowired
    private PulsarTemplate<String> stringTemplate;

    private static final String TOPIC = "new-topic";

    public void publishMessage(String message) {
        stringTemplate.send(TOPIC, message);
    }
}

