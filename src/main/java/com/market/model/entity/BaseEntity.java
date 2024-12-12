package com.market.model.entity;

import com.market.config.TenantContext;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@MappedSuperclass
@FilterDef(
        name = "tenantFilter",
        parameters = @ParamDef(name = "tenantId", type = String.class)
)
@Filter(name = "tenantFilter", condition = "tenant_id = :tenantId")
public abstract class BaseEntity {

    @Column(name = "tenant_id")
    private String tenantId;

    @PrePersist
    public void prePersist() {
        if (tenantId == null) {
            tenantId = TenantContext.getCurrentTenant();
        }
    }
}

