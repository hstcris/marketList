package com.market.controllers;

import com.market.model.entity.PriceHistory;
import com.market.model.service.PriceHistoryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/price-history")
public class PriceHistoryController {

    
    @Autowired
    private PriceHistoryService priceHistoryService;

    @PostMapping
    public ResponseEntity<PriceHistory> createPriceHistory(@RequestBody PriceHistory priceHistory) {
        try {
            PriceHistory createdPriceHistory = priceHistoryService.createPriceHistory(priceHistory);
            return new ResponseEntity<>(createdPriceHistory, HttpStatus.CREATED);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<PriceHistory>> getAllPriceHistories() {
        List<PriceHistory> priceHistories = priceHistoryService.findAllPriceHistories();
        return new ResponseEntity<>(priceHistories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PriceHistory> getPriceHistoryById(@PathVariable Long id) {
        Optional<PriceHistory> priceHistory = priceHistoryService.findPriceHistoryById(id);
        if (priceHistory.isPresent()) {
            return new ResponseEntity<>(priceHistory.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PriceHistory> updatePriceHistory(@PathVariable Long id, @RequestBody PriceHistory priceHistory) {
        try {
            PriceHistory updatedPriceHistory = priceHistoryService.updatePriceHistory(id, priceHistory);
            return new ResponseEntity<>(updatedPriceHistory, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePriceHistory(@PathVariable Long id) {
        try {
            priceHistoryService.deletePriceHistory(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
    

