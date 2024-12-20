package com.market.model.service;

import com.market.model.entity.PriceHistory;
import com.market.model.repositories.PriceHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PriceHistoryService {

    private final PriceHistoryRepository priceHistoryRepository;

    @Autowired
    public PriceHistoryService(PriceHistoryRepository priceHistoryRepository) {
        this.priceHistoryRepository = priceHistoryRepository;
    }

    public PriceHistory createPriceHistory(PriceHistory priceHistory) {
        return priceHistoryRepository.save(priceHistory);
    }

    public Optional<PriceHistory> findPriceHistoryById(Long id) {
        return priceHistoryRepository.findById(id);
    }

}
