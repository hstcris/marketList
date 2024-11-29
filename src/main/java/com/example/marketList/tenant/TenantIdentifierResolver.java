package com.example.marketList.tenant;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver {

    @Override
    public String resolveCurrentTenantIdentifier() {
        // Aqui você pode pegar o tenant ID da requisição. Exemplo: de um cabeçalho "X-Tenant-Id"
        String tenantId = TenantContext.getCurrentTenant();
        if (tenantId == null) {
            throw new IllegalStateException("Tenant identifier is not set!");
        }
        return tenantId;
    }

    @Override
    @org.checkerframework.checker.nullness.qual.UnknownKeyFor
    @org.checkerframework.checker.nullness.qual.NonNull
    @org.checkerframework.checker.initialization.qual.Initialized
    public boolean validateExistingCurrentSessions() {
        return false;
    }

    @Override
    @org.checkerframework.checker.nullness.qual.UnknownKeyFor
    @org.checkerframework.checker.nullness.qual.NonNull
    @org.checkerframework.checker.initialization.qual.Initialized
    public boolean isRoot(Object tenantId) {
        return CurrentTenantIdentifierResolver.super.isRoot(tenantId);
    }

    @Override
    public boolean tenantExists(String tenantIdentifier) {
        // Verificar se o tenant existe
        return tenantIdentifier != null;
    }
}
