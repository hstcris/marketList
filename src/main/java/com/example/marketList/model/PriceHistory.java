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
@Table(name = "price_history")
public class PriceHistory {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "purchase_item_id", nullable = false)
        private PurchaseItem purchaseItem;

        @Column(name = "tenant_id", nullable = false)
        private String tenantId;

        @Column(name = "price", nullable = false)
        private BigDecimal price;

        @Column(name = "date", nullable = false)
        private LocalDate date;

}

