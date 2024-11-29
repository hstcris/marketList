package com.example.marketList.controllers;

import com.example.marketList.model.PriceHistory;
import com.example.marketList.service.PriceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/price-history")
public class PriceHistoryController {

    private final PriceHistoryService priceHistoryService;

    @Autowired
    public PriceHistoryController(PriceHistoryService priceHistoryService) {
        this.priceHistoryService = priceHistoryService;
    }

    // Get price history for an item
    @GetMapping("/item/{itemId}")
    public List<PriceHistory> getPriceHistory(@PathVariable Long itemId, @RequestHeader("X-Tenant-Id") String tenantId) {
        return priceHistoryService.getPriceHistoryForItem(itemId, tenantId);
    }
}
