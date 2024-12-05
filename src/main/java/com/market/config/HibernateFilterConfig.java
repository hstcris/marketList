package com.market.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class HibernateFilterConfig {

    @PersistenceContext
    private EntityManager entityManager;

    public void configureTenantFilter(){
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("tenantFilter");
        filter.setParameter("tenantId", TenantContext.getCurrentTenant());
    }
}
