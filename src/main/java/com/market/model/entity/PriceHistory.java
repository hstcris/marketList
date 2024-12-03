package com.market.model.entity;

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
@Table(name = "tb_price_history")
public class PriceHistory {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "product_name", nullable = false)
        private String productName;

        @Column(name = "price", nullable = false)
        private BigDecimal price;

        @Column(name = "date", nullable = false)
        private LocalDate date;

        @ManyToOne
        @JoinColumn(name = "purchase_list_id", referencedColumnName = "id")
        private PurchaseList purchaseList;

        @Column(name = "tenant_id", nullable = false)
        private String tenantId;

}
