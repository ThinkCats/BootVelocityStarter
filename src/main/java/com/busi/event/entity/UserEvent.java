package com.busi.event.entity;

import lombok.Data;

/**
 * @author WangLei
 * on 2018/2/11
 */
@Data
public class UserEvent {
    private String username;
    private String password;
    private Integer enabled;

}
