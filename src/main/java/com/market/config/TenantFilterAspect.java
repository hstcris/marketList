package com.market.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TenantFilterAspect {

    @Autowired
    HibernateFilterConfig filterConfig;

    @Before("execution(* org.springframework.data.jpa.repository.JpaRepository+.*(..))")
    public void applyTenantFilter() {
        filterConfig.configureTenantFilter();
        System.out.println("------------------FILTRO APLICADO---------------");
    }
}