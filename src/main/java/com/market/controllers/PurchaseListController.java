package com.market.controllers;

import com.market.model.entity.PurchaseList;
import com.market.model.service.PurchaseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/purchase-lists")
public class PurchaseListController {

    private final PurchaseListService purchaseListService;

    @Autowired
    public PurchaseListController(PurchaseListService purchaseListService) {
        this.purchaseListService = purchaseListService;
    }

    @PostMapping
    public ResponseEntity<PurchaseList> createPurchaseList(@RequestBody PurchaseList purchaseList) {
        PurchaseList createdPurchaseList = purchaseListService.createPurchaseList(purchaseList);
        return ResponseEntity.ok(createdPurchaseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseList> getPurchaseListById(@PathVariable Long id) {
        Optional<PurchaseList> purchaseList = purchaseListService.findPurchaseListById(id);
        return purchaseList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<PurchaseList> getAllPurchaseLists() {
        return purchaseListService.findAllPurchaseLists();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchaseList(@PathVariable Long id) {
        purchaseListService.deletePurchaseList(id);
        return ResponseEntity.noContent().build();
    }
}
