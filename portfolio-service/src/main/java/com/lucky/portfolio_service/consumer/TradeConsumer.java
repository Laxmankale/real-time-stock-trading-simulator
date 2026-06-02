package com.lucky.portfolio_service.consumer;

import com.lucky.portfolio_service.dto.TradeEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TradeConsumer {

    @KafkaListener(
            topics = "trade-events",
            groupId = "portfolio-group"
    )
    public void consumeTradeEvent(TradeEvent tradeEvent) {

        System.out.println("Trade Event Received: " + tradeEvent);

    }
}