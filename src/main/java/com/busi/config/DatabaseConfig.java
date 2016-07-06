package com.busi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.PostConstruct;

/**
 * Created by wl on 16/7/5.
 * For H2 / HSQL database
 */
@Configuration
public class DatabaseConfig {

    @Autowired
    private JdbcTemplate template;

    @PostConstruct
    public void initDB(){
        template.execute("CREATE TABLE IF NOT EXISTS users (\n" +
                "  id         INTEGER PRIMARY KEY,\n" +
                "  name VARCHAR(30),\n" +
                "  email  VARCHAR(50)\n" +
                ");");
    }
}
