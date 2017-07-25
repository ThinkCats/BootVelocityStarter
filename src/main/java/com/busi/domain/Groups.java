package com.busi.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by hehe on 2017/7/25.
 */
@Entity
@Table(name = "groups")
@Data
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "group_name")
    private String groupName;
}
