package com.market.model.service;

import com.market.model.entity.PriceHistory;
import com.market.model.repositories.PriceHistoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PriceHistoryService {

    private final PriceHistoryRepository priceHistoryRepository;

    @Autowired
    public PriceHistoryService(PriceHistoryRepository priceHistoryRepository) {
        this.priceHistoryRepository = priceHistoryRepository;
    }

    public PriceHistory createPriceHistory(PriceHistory priceHistory) {
        if (priceHistory.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }
        return priceHistoryRepository.save(priceHistory);
    }

    public List<PriceHistory> findAllPriceHistories() {
        return priceHistoryRepository.findAll();
    }

    public Optional<PriceHistory> findPriceHistoryById(Long id) {
        return priceHistoryRepository.findById(id);
    }

    public PriceHistory updatePriceHistory(Long id, PriceHistory updatedPriceHistory) {
        Optional<PriceHistory> existingPriceHistory = priceHistoryRepository.findById(id);
        if (!existingPriceHistory.isPresent()) {
            throw new IllegalArgumentException("Registro com o id " + id + " não encontrado.");
        }
        
        updatedPriceHistory.setId(id);
        return priceHistoryRepository.save(updatedPriceHistory);
    }

    public void deletePriceHistory(Long id) {
        if (!priceHistoryRepository.existsById(id)) {
            throw new IllegalArgumentException("Não é possível excluir, o registro com o id " + id + " não foi encontrado.");
        }
        priceHistoryRepository.deleteById(id);
    }
}

