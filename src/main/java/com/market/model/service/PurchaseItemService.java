package com.market.model.service;

import com.market.model.entity.PurchaseItem;
import com.market.model.repositories.PurchaseItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Transactional
@Service
public class PurchaseItemService {

    private final PurchaseItemRepository purchaseItemRepository;

    @Autowired
    public PurchaseItemService(PurchaseItemRepository purchaseItemRepository) {
        this.purchaseItemRepository = purchaseItemRepository;
    }

    public PurchaseItem createPurchaseItem(PurchaseItem purchaseItem) {
        return purchaseItemRepository.save(purchaseItem);
    }

    public Optional<PurchaseItem> findPurchaseItemById(Long id) {
        return purchaseItemRepository.findById(id);
    }

    public void deletePurchaseItem(Long id) {
        purchaseItemRepository.deleteById(id);
    }
}
