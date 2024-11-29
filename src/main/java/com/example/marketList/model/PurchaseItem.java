package com.example.marketList.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchase_item")
public class PurchaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "purchase_list_id", nullable = false)
    private PurchaseList purchaseList;

    @Column(name = "tenant_id", nullable = false)
    private String tenantId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private BigDecimal quantity;

    @Column(name = "price_at_last_purchase")
    private BigDecimal priceAtLastPurchase;

    @Column(name = "current_price", nullable = false)
    private BigDecimal currentPrice;

    @Column(name = "last_purchase_date")
    private LocalDate lastPurchaseDate;


}

