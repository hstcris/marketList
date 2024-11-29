package com.example.marketList.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(name = "tenant_id", nullable = false)
    private String tenantId;

    @Column(name = "list_name")
    private String listName;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @OneToMany(mappedBy = "purchaseList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseItem> items;


}

