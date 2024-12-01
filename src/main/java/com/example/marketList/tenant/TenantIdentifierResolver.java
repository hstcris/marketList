package com.example.marketList.tenant;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Component
public class TenantIdentifierResolver {

    public String resolveCurrentTenantIdentifier() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String tenantId = request.getHeader("X-Tenant-ID");

        if (tenantId == null || tenantId.isEmpty()) {
            tenantId = "default_tenant";
        }

        return tenantId;
    }
}
