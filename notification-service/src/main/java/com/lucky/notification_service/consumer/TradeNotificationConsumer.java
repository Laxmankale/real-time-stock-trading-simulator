package com.lucky.notification_service.consumer;

import com.lucky.notification_service.dto.TradeEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TradeNotificationConsumer {

    @KafkaListener(
            topics = "trade-events",
            groupId = "notification-group"
    )
    public void consumeTradeEvent(TradeEvent tradeEvent) {

        System.out.println(
                "Notification Sent: "
                        + tradeEvent.getTradeType()
                        + " "
                        + tradeEvent.getQuantity()
                        + " shares of "
                        + tradeEvent.getStockName()
        );

    }
}