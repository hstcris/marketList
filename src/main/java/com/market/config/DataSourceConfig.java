package com.market.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        AbstractRoutingDataSource dataSource = new AbstractRoutingDataSource() {
            @Override
            protected Object determineCurrentLookupKey() {
                return TenantContext.getCurrentTenant();
            }
        };

        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("tenant1", createDataSource("jdbc:postgresql://localhost:5432/market_db"));
        targetDataSources.put("tenant2", createDataSource("jdbc:postgresql://localhost:5432/tenant2_db"));

        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(createDataSource("jdbc:postgresql://localhost:5432/default_db"));

        return dataSource;
    }

    private DataSource createDataSource(String url) {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setUrl(url);
        dataSource.setUsername("postgres");
        dataSource.setPassword("password");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, TenantIdentifierResolver tenantIdentifierResolver) {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.market.model");
        
        factoryBean.getJpaPropertyMap().put("hibernate.multiTenancy", "DATABASE");
        factoryBean.getJpaPropertyMap().put("hibernate.tenant_identifier_resolver", tenantIdentifierResolver);
        factoryBean.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "update");
        factoryBean.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        factoryBean.getJpaPropertyMap().put("hibernate.persistence.provider", "org.hibernate.jpa.HibernatePersistenceProvider");

        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
