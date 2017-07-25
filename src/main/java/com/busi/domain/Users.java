package com.busi.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hehe on 2017/7/25.
 */
@Entity
@Data
@Table(name = "users")
@ToString
public class Users {
    @Id
    private String username;
    private String password;
    private Integer enabled;
}
