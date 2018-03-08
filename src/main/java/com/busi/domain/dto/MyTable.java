package com.busi.domain.dto;

import com.busi.interceptor.annotation.Table;

/**
 * @author WangLei
 * on 2018/3/8
 */
@Table(isPrimayTable = true)
public class MyTable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
