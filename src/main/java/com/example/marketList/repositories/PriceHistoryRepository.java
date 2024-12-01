package com.example.marketList.repositories;

import com.example.marketList.model.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Long> {
    List<PriceHistory> findByPurchaseItemId(Long itemId);
}
