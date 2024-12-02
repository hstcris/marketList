package com.market.config;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class TenantFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String tenantId = ((HttpServletRequest) request).getHeader("X-Tenant-ID");

        if (tenantId != null) {
            TenantContext.setCurrentTenant(tenantId);
        }

        try {
            chain.doFilter(request, response);
        } finally {
            TenantContext.clear();
        }
    }
}
