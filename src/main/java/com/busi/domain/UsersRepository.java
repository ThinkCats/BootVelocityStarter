package com.busi.domain;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by hehe on 2017/7/25.
 */
public interface UsersRepository extends CrudRepository<Users, Long> {
    Users findByUsername(String username);
}
