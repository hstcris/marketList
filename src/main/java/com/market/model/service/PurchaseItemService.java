package com.market.model.service;

import com.market.model.entity.PurchaseItem;
import com.market.model.repositories.PurchaseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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

    public List<PurchaseItem> findPurchaseItemsByListId(Long purchaseListId) {
        return purchaseItemRepository.findByPurchaseListId(purchaseListId);
    }

    public void deletePurchaseItem(Long id) {
        purchaseItemRepository.deleteById(id);
    }
}
