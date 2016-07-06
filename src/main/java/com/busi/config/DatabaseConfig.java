package com.busi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

/**
 * Created by wl on 16/7/5.
 * For H2 / HSQL database
 */
@Slf4j
@Configuration
public class DatabaseConfig {

    @Autowired
    private JdbcTemplate template;

    @PostConstruct
    public void initDB(){
        log.info("====> DB Init");
        template.execute("CREATE TABLE IF NOT EXISTS users (\n" +
                "  id         INTEGER PRIMARY KEY,\n" +
                "  name VARCHAR(30),\n" +
                "  email  VARCHAR(50)\n" +
                ");");
    }
}
