package com.busi.state.enums;

import lombok.Getter;

/**
 * @author WangLei
 * on 2018/6/23
 */
public enum StatusEnum {

    INIT(0,"初始化订单"),
    WAIT_SIGN_AGREEMENT(200,"待签合同"),
    WAIT_PAID(220,"待支付"),
    WAIT_CONFIRM(250,"待匹配")

    ;

    @Getter
    private int status;
    @Getter
    private String desc;

    StatusEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
