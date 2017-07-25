package com.busi.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by hehe on 2017/7/25.
 */
public interface GroupMembersRepository extends CrudRepository<GroupMembers, Long> {
    List<GroupMembers> findByUsername(String username);
}
