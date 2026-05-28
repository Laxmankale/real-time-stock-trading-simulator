package com.lucky.trade_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeEvent {

    @NotBlank(message = "Stock name cannot be empty")
    private String stockName;
    
    @Positive(message = "Quantity must be greater than zero")
    private int quantity;
    
    @NotBlank(message = "Trade type must be provided (e.g., BUY or SELL)")
    private String tradeType;
}