package com.example.marketList.repositories;

import com.example.marketList.model.PurchaseList;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface PurchaseListRepository extends JpaRepository<PurchaseList, Long> {
    List<PurchaseList> findByTenantId(String tenantId);
}

