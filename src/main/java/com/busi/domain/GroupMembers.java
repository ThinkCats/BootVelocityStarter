package com.busi.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by hehe on 2017/7/25.
 */
@Entity
@Data
@Table(name = "group_members")
public class GroupMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    @Column(name = "group_id")
    private Long groupId;
}
