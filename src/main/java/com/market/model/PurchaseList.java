package com.market.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchase_list")
public class PurchaseList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "month", nullable = false)
    private String month;

    @Column(name = "tenant_id", nullable = false)
    private String tenantId;

    @OneToMany(mappedBy = "purchaseList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PurchaseItem> items;

    @OneToMany(mappedBy = "purchaseList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PriceHistory> priceHistory;
}
