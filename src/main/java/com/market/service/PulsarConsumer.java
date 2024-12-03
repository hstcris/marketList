package com.market.service;

import org.springframework.pulsar.annotation.PulsarListener;
import org.springframework.stereotype.Service;

//classe para consumir as mensagens
@Service
public class PulsarConsumer {

    @PulsarListener(topics = "new-topic")
    public void consumeMessage(String message) {
        System.out.println("Message receive: " + message);
    }
}

