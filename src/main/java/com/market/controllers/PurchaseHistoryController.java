package com.market.controllers;

import com.market.model.entity.PriceHistory;
import com.market.model.repositories.PriceHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/price-history")
public class PurchaseHistoryController {

    @Autowired
    private PriceHistoryRepository priceHistoryRepository;

    @PostMapping
    public PriceHistory createPriceHistory(@RequestBody PriceHistory priceHistory) {
        return priceHistoryRepository.save(priceHistory);
    }
}