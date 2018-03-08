package com.busi.domain.dto;

import com.busi.interceptor.annotation.Table;

/**
 * @author WangLei
 * on 2018/3/8
 */
@Table
public class OtherTable {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
