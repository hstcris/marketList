package com.market.config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class MultiTenantConfig {

    @Bean(name = "entityManagerFactoryMultiTenant")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
                                                                       TenantIdentifierResolver tenantIdentifierResolver) throws HibernateException {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.market.model");

        factoryBean.getJpaPropertyMap().put("hibernate.multiTenancy", "DATABASE");
        factoryBean.getJpaPropertyMap().put("hibernate.tenant_identifier_resolver", tenantIdentifierResolver);

        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
