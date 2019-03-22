package com.busi.state.enums;

import lombok.Getter;

/**
 * @author WangLei
 * on 2018/6/24
 */
public enum StatusEvent{

    CREATE("生成订单"),
    SIGN_AGREEMENT("签署合同"),
    PAY("支付")
    ;

    @Getter
    private String desc;

    StatusEvent(String desc) {
        this.desc = desc;
    }
}
