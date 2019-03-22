package com.busi.domain.vo;

import lombok.Data;

/**
 * @author WangLei
 * on 2018/2/9
 */
@Data
public class Result {
    private boolean success;
    private String msg;

    public Result(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public static Result success(String msg){
        return new Result(true,msg);
    }

}
