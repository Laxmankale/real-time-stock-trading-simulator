package com.lucky.trade_service.producer;

import com.lucky.trade_service.dto.TradeEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TradeProducer {

    private final KafkaTemplate<String, TradeEvent> kafkaTemplate;

    public TradeProducer(KafkaTemplate<String, TradeEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTradeEvent(TradeEvent tradeEvent) {
        kafkaTemplate.send("trade-events", tradeEvent);

        System.out.println("Trade Event Sent: " + tradeEvent);
    }
}