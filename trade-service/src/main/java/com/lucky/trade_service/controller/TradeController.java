package com.lucky.trade_service.controller;

import com.lucky.trade_service.dto.TradeEvent;
import com.lucky.trade_service.producer.TradeProducer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/trade")
public class TradeController {

    private final TradeProducer tradeProducer;

    public TradeController(TradeProducer tradeProducer) {
        this.tradeProducer = tradeProducer;
    }

    @PostMapping
    public String placeTrade(@Valid @RequestBody TradeEvent tradeEvent) {

        try {
            tradeProducer.sendTradeEvent(tradeEvent);
        } catch (IllegalStateException ex) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage(), ex);
        }

        return "Trade Event Sent Successfully";
    }

}
