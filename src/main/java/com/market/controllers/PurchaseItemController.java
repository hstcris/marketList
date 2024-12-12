package com.market.controllers;

import com.market.model.entity.PurchaseItem;
import com.market.model.repositories.PurchaseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/purchase-items")
public class PurchaseItemController {

    @Autowired
    private PurchaseItemRepository purchaseItemRepository;

    @PostMapping
    public PurchaseItem createPurchaseItem(@RequestBody PurchaseItem purchaseItem) {
        return purchaseItemRepository.save(purchaseItem);
    }
}