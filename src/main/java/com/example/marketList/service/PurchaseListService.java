package com.example.marketList.service;

import com.example.marketList.model.PurchaseList;
import com.example.marketList.repositories.PurchaseListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class PurchaseListService {

    @Autowired
    private PurchaseListRepository purchaseListRepository;

    @Autowired
    private PurchaseItemRepository purchaseItemRepository;

    @Autowired
    private PriceHistoryRepository priceHistoryRepository;

    @Autowired
    private SupermarketApiService supermarketApiService;

    // Create purchase list
    public PurchaseList createPurchaseList(PurchaseList purchaseList) {
        // Set creation date
        purchaseList.setCreatedDate(LocalDate.now());

        // For each item in the list, fetch the current price and save the item
        for (PurchaseItem item : purchaseList.getItems()) {
            BigDecimal currentPrice = supermarketApiService.getCurrentPrice(item.getName());
            item.setCurrentPrice(currentPrice);
            item.setPriceAtLastPurchase(BigDecimal.ZERO); // Initially no previous price

            // Save price history
            PriceHistory priceHistory = new PriceHistory();
            priceHistory.setPrice(currentPrice);
            priceHistory.setDate(LocalDate.now());
            priceHistory.setPurchaseItem(item);
            priceHistoryRepository.save(priceHistory);

            purchaseItemRepository.save(item);
        }

        return purchaseListRepository.save(purchaseList);
    }

    // Get all purchase lists for a tenant
    public List<PurchaseList> getAllPurchaseLists(String tenantId) {
        return purchaseListRepository.findByTenantId(tenantId);
    }

    // Update item price
    public PurchaseItem updateItemPrice(Long itemId, BigDecimal newPrice) {
        PurchaseItem item = purchaseItemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));
        item.setCurrentPrice(newPrice);
        purchaseItemRepository.save(item);

        // Save price history
        PriceHistory priceHistory = new PriceHistory();
        priceHistory.setPrice(newPrice);
        priceHistory.setDate(LocalDate.now());
        priceHistory.setPurchaseItem(item);
        priceHistoryRepository.save(priceHistory);

        return item;
    }

    // Delete an item
    public void deleteItem(Long itemId) {
        purchaseItemRepository.deleteById(itemId);
    }
}
