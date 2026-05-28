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
        try {
            SendResult<String, TradeEvent> result = kafkaTemplate
                    .send(TRADE_EVENTS_TOPIC, tradeEvent)
                    .get(10, TimeUnit.SECONDS);

            System.out.println("Trade Event Sent: " + tradeEvent + " to partition "
                    + result.getRecordMetadata().partition());
        } catch (Exception ex) {
            throw new IllegalStateException("Unable to send trade event to Kafka. Make sure Kafka is running on "
                    + "spring.kafka.bootstrap-servers.", ex);
        }
    }
}
