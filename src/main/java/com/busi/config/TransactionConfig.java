package com.busi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by hehe on 2017/7/25.
 */
@Configuration
public class TransactionConfig {

    @Autowired
    private DataSource dataSource;

    /**
     * config transaction
     */
    @Bean
    @ConditionalOnMissingBean(name = "transactionManager")
    @ConditionalOnBean(DataSource.class)
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(this.dataSource);
    }
}
