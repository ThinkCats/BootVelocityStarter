package com.app.db;

import com.app.BaseApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by wl on 16/7/7.
 */
@Slf4j
public class H2Test extends BaseApplicationTests {

    @Autowired
    private JdbcTemplate template;

    @Test
    public void testDataAccess() {
        List list = template.queryForList("select * from users");
        log.info("result:" + list.toString());
    }

    @Test
    public void addData() {
        String sql = "INSERT INTO users VALUES (4, 'joel');";
        template.execute(sql);
        testDataAccess();
    }
}
