package com.market.config;

public class TenantContext {

    private TenantContext() {
    }
    private static final ThreadLocal<String> currentTenant = new ThreadLocal<>();

    public static String getCurrentTenant() {
        return currentTenant.get();
    }
    public static void setCurrentTenant(String tenant) {
        currentTenant.set(tenant);
    }
    public static void clear() {
        currentTenant.remove();
    }
}
