package com.market.repositories;


import com.market.model.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long> {
    List<PurchaseItem> findByPurchaseListId(Long purchaseListId);

    @Query("SELECT pi FROM PurchaseItem pi WHERE pi.purchaseList.tenantId = :tenantId")
    List<PurchaseItem> findItemsByTenant(@Param("tenantId") String tenantId);
}