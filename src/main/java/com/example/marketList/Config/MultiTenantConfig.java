package com.example.marketList.Config;

import com.example.marketList.tenant.TenantIdentifierResolver;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.repository")
public class MultiTenantConfig {

    private final TenantIdentifierResolver tenantIdentifierResolver;

    @Autowired
    public MultiTenantConfig(TenantIdentifierResolver tenantIdentifierResolver) {
        this.tenantIdentifierResolver = tenantIdentifierResolver;
    }

    private Map<Object, Object> getDataSources() {
        Map<Object, Object> dataSources = new HashMap<>();

        String tenant1Url = "jdbc:mysql://localhost:3306/market_tenant1";
        String tenant2Url = "jdbc:mysql://localhost:3306/market_tenant2";

        dataSources.put("tenant1", createDataSource(tenant1Url));
        dataSources.put("tenant2", createDataSource(tenant2Url));

        return dataSources;
    }

    private DataSource createDataSource(String dbUrl) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(dbUrl);
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        return dataSource;
    }

    @Bean
    public DataSource dataSource() {
        AbstractRoutingDataSource dataSourceRouting = new AbstractRoutingDataSource() {
            @Override
            protected Object determineCurrentLookupKey() {
                return tenantIdentifierResolver.resolveCurrentTenantIdentifier();
            }
        };

        dataSourceRouting.setTargetDataSources(getDataSources());
        return dataSourceRouting;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.example.model");
        factoryBean.setPersistenceUnitName("market");
        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
