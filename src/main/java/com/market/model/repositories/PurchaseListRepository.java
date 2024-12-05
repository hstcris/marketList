package com.market.model.repositories;

import com.market.model.entity.PurchaseList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PurchaseListRepository extends JpaRepository<PurchaseList, Long> {
    List<PurchaseList> findByTenantId(String tenantId);

    @Query("SELECT pi FROM PurchaseItem pi WHERE pi.purchaseList.tenantId = :tenantId")
    List<PurchaseList> findItemsByTenant(@Param("tenantId") String tenantId);

}

