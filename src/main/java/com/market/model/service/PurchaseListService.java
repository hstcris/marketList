package com.market.model.service;

import com.market.model.entity.PurchaseList;
import com.market.model.repositories.PurchaseListRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PurchaseListService {

    private final PurchaseListRepository purchaseListRepository;

    @Autowired
    public PurchaseListService(PurchaseListRepository purchaseListRepository) {
        this.purchaseListRepository = purchaseListRepository;
    }

    public PurchaseList createPurchaseList(PurchaseList purchaseList) {
        return purchaseListRepository.save(purchaseList);
    }

    public Optional<PurchaseList> findPurchaseListById(Long id) {
        return purchaseListRepository.findById(id);
    }

    public List<PurchaseList> findAllPurchaseLists() {
        return purchaseListRepository.findAll();
    }

    public void deletePurchaseList(Long id) {
        purchaseListRepository.deleteById(id);
    }
}
