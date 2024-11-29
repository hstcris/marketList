package com.example.marketList.controllers;

import com.example.marketList.model.PurchaseList;
import com.example.marketList.service.PurchaseListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-lists")
public class PurchaseListController {

    @Autowired
    private PurchaseListService purchaseListService;

    // Create a new purchase list
    @PostMapping
    public PurchaseList createPurchaseList(@RequestBody PurchaseList purchaseList) {
        return purchaseListService.createPurchaseList(purchaseList);
    }

    // Get all purchase lists for a tenant
    @GetMapping
    public List<PurchaseList> getPurchaseLists(@RequestHeader("X-Tenant-Id") String tenantId) {
        return purchaseListService.getAllPurchaseLists(tenantId);
    }
}

