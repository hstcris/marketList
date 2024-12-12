package com.market.model.repositories;

import com.market.model.entity.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseItemRepository extends JpaRepository<PurchaseItem, Long> {

}