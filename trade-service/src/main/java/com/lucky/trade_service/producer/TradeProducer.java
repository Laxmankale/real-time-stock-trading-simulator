package com.lucky.trade_service.producer;

import com.lucky.trade_service.dto.TradeEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TradeProducer {

    private static final String TRADE_EVENTS_TOPIC = "trade-events";

    private final KafkaTemplate<String, TradeEvent> kafkaTemplate;

    public TradeProducer(KafkaTemplate<String, TradeEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTradeEvent(TradeEvent tradeEvent) {
        kafkaTemplate.send(TRADE_EVENTS_TOPIC, tradeEvent).whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Trade Event Sent: " + tradeEvent + " to partition "
                        + result.getRecordMetadata().partition());
            } else {
                System.err.println("Unable to send trade event to Kafka. Error: " + ex.getMessage());
                // In a real app, you might want to send this to a Dead Letter Queue (DLQ) or trigger an alert
            }
        });
    }
}
