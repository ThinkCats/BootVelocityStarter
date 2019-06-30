package com.busi.domain;

import com.souche.tangeche.comment.Comment;
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
@Comment("用户信息描述")
public class Users {
    @Id
    @Comment("用户姓名")
    private String username;
    @Comment("密码")
    private String password;
    @Comment("是否启用")
    private Integer enabled;

}
