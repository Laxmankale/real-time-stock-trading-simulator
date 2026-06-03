package com.lucky.notification_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeEvent {

    private String stockName;
    private int quantity;
    private String tradeType;
}