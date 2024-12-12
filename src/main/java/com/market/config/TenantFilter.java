package com.market.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TenantFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String tenantId = request.getHeader("tenant-id");
        if (tenantId != null && !tenantId.isBlank()) {
            TenantContext.setCurrentTenant(tenantId);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing tenant-id header");
            return;
        }

        try {
            filterChain.doFilter(request, response);
        } finally {
            TenantContext.clear();
        }
    }
}
