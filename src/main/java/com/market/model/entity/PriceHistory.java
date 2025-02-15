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
@Table(name = "tb_price_history_new")
public class PriceHistory extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "product_name", nullable = false)
        private String productName;

        @Column(name = "price", nullable = false, precision = 10, scale = 2)
        private BigDecimal price;

        @Column(name = "date", nullable = false)
        private LocalDate date;
}
