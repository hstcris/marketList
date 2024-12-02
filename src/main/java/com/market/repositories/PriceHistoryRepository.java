package com.market.repositories;

import com.market.model.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Long> {
    List<PriceHistory> findByPurchaseItemId(Long itemId);

    List<PriceHistory> findByItemId(Long itemId);

    @Query("SELECT pi FROM PurchaseItem pi WHERE pi.purchaseList.tenantId = :tenantId")
    List<PriceHistory> findItemsByTenant(@Param("tenantId") String tenantId);
}
